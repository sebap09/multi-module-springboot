package pl.myproject.Services;

import pl.myproject.Entities.Family;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Exceptions.*;
import pl.myproject.Repositories.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    private final JdbcAggregateTemplate jdbcAggregateTemplate;
    private final FamilyRepo familyRepo;
    private final WebClientService webClientService;

    @Autowired
    public FamilyService(JdbcAggregateTemplate jdbcAggregateTemplate, FamilyRepo familyRepo, WebClientService webClientService) {
        this.jdbcAggregateTemplate = jdbcAggregateTemplate;
        this.familyRepo = familyRepo;
        this.webClientService = webClientService;
    }

    public Family saveWithMyId(Family family){
       return jdbcAggregateTemplate.insert(family);
    }
    public void validateFamilyData(Family family){
        List<FamilyMember> list=family.getMembers();
        if(list==null)
            throw new NullMembersListException();

        String familyName=family.getFamilyName();
        if(familyName==null||familyName.length()==0)
            throw new InvalidFamilyNameException();

        int nrOfInfants=0;
        int nrOfChildren=0;
        int nrOfAdults=0;

        for(FamilyMember familyMember : list){
            Integer age=familyMember.getAge();
            String memberFamilyName=familyMember.getFamilyName();
            String givenName=familyMember.getGivenName();

            if(memberFamilyName==null||memberFamilyName.length()==0)
                throw new InvalidMemberFamilyNameException();
            if(givenName==null||givenName.length()==0)
                throw new InvalidGivenNameException();
            if(age==null||age<0)
                throw new InvalidAgeException();

            //validation if provided family data match
            if(age<4)
                nrOfInfants++;
            if(age>=4&&age<16)
                nrOfChildren++;
            if(age>=16)
                nrOfAdults++;
        }

            if(!(family.getNrOfInfants()==nrOfInfants
                    &&family.getNrOfChildren()==nrOfChildren
                    &&family.getNrOfAdults()==nrOfAdults))
                throw new FamilyDataValidationException();
    }

    public Integer generateFamilyId(){
        Integer lastId=familyRepo.getLastId().orElse(0);
        return ++lastId;
    }

    public void makePostRequests(Family family){
        List<FamilyMember> list=family.getMembers();
        for(FamilyMember familyMember : list){
            familyMember.setFamilyId(family.getId());
            webClientService.postRequest(familyMember);
        }
    }

    public Family makeGetRequestAndAggregate(Family family){
        List<FamilyMember> members=webClientService.getRequest(family.getId());
        family.setMembers(members);
        return family;
    }

    public Family findById(Integer familyId){
        return familyRepo.findById(familyId).orElseThrow(FamilyNotFoundException::new);
    }
}
