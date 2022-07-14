package pl.myproject.Services;

import pl.myproject.Entities.Family;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Exceptions.*;
import pl.myproject.Services.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class FamilyDataValidationTest {

    @Autowired
    FamilyService familyService;
    Family testFamily;
    List<FamilyMember> testFamilyMemberList;

    @BeforeEach
    void setFamilyData(){
        testFamilyMemberList =List.of();
        testFamily= new Family("Nowak",1,0,0, testFamilyMemberList);
    }
    @Test
    void nullFamilyName_InvalidFamilyNameException(){
        assertThrows(InvalidFamilyNameException.class,
                ()->{
                    testFamily.setFamilyName(null);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void emptyFamilyName_InvalidFamilyNameException(){
        assertThrows(InvalidFamilyNameException.class,
                ()->{
                    testFamily.setFamilyName("");
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void nullGivenName_InvalidGivenNameException(){
        assertThrows(InvalidGivenNameException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"Nowak",null,18  );
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void emptyGivenName_InvalidGivenNameException(){
        assertThrows(InvalidGivenNameException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","",18);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void nullMemberFamilyName_InvalidMemberFamilyNameException(){
        assertThrows(InvalidMemberFamilyNameException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,null,"Jan",18);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void emptyMemberFamilyName_InvalidMemberFamilyNameException(){
        assertThrows(InvalidMemberFamilyNameException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"","Jan",18);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void nullAge_InvalidAgeException(){
        assertThrows(InvalidAgeException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","Jan",null);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void negativeAge_InvalidAgeException(){
        assertThrows(InvalidAgeException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","Jan",-10);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void nullMembersList_NullMembersListException(){
        assertThrows(NullMembersListException.class,
                ()->{
                    testFamilyMemberList=null;
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void wrongNumberOfAdults_FamilyDataValidationException(){
        assertThrows(FamilyDataValidationException.class,
                ()->{
                    testFamily.setNrOfAdults(0);
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","Jan",18);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void wrongNumberOfInfants_FamilyDataValidationException(){
        assertThrows(FamilyDataValidationException.class,
                ()->{
                    testFamily.setNrOfInfants(0);
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","Jan",2);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }

    @Test
    void wrongNumberOfChildren_FamilyDataValidationException(){
        assertThrows(FamilyDataValidationException.class,
                ()->{
                    testFamily.setNrOfChildren(0);
                    FamilyMember familyMember = new FamilyMember(1,"Nowak","Jan",10);
                    testFamilyMemberList=List.of(familyMember);
                    testFamily.setMembers(testFamilyMemberList);
                    familyService.validateFamilyData(testFamily);
                });
    }
}
