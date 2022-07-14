package pl.myproject.Entities;

import org.springframework.data.annotation.Id;

public class FamilyMember {
    @Id
    private Integer id;
    private Integer familyId;
    private String familyName;
    private String givenName;
    private Integer age;

    public FamilyMember(){}

    public FamilyMember(Integer familyId, String familyName, String givenName, Integer age) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.givenName = givenName;
        this.age = age;
    }

    public FamilyMember(Integer id, Integer familyId, String familyName, String givenName, Integer age) {
        this.id = id;
        this.familyId = familyId;
        this.familyName = familyName;
        this.givenName = givenName;
        this.age = age;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
