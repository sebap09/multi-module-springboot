package pl.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Exceptions.NoSuchFamilyIdException;
import pl.myproject.Repositories.FamilyMemberRepo;

import java.util.List;

@Service
public class FamilyMemberService {

    private final FamilyMemberRepo familyMemberRepo;

    @Autowired
    public FamilyMemberService(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }

    public FamilyMember save(FamilyMember familyMember){
        return familyMemberRepo.save(familyMember);
    }

    public List<FamilyMember> findByFamilyId(Integer familyId) {
        List<FamilyMember> queriedList=familyMemberRepo.findAllByFamilyId(familyId);
        if(queriedList.size()==0)
            throw new NoSuchFamilyIdException();
        return queriedList;
    }
}
