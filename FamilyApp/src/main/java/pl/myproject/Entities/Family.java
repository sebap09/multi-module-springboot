package pl.myproject.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

public class Family {
    @Id
    private Integer id;
    private  String familyName;
    private  Integer nrOfAdults;
    private Integer nrOfChildren;
    private Integer nrOfInfants;

    public List<FamilyMember> getMembers() {
        return members;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMembers(List<FamilyMember> members) {
        this.members = members;
    }

    @Transient
    private List<FamilyMember> members;



    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(Integer nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public Integer getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(Integer nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public Integer getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(Integer nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    public Family() {
    }

    public Family(Integer id, String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants, List<FamilyMember> familyMemberList) {
        this.id = id;
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
        this.members =familyMemberList;
    }

    public Family(String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants, List<FamilyMember> familyMemberList) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
        this.members =familyMemberList;
    }
}
