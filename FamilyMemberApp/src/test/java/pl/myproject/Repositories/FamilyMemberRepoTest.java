package pl.myproject.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Repositories.FamilyMemberRepo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJdbcTest
@AutoConfigureTestDatabase
public class FamilyMemberRepoTest {

    private final FamilyMemberRepo familyMemberRepo;

    @Autowired
    public FamilyMemberRepoTest(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }

    @Test
    public void listMembers_ShouldReturnEmptyList(){
        List<FamilyMember> members=familyMemberRepo.findAllByFamilyId(1);
        assertEquals(0,members.size());
    }

    @Test
    public void familyMember_ShouldReturnProperlySavedMember(){
        FamilyMember familyMember = new FamilyMember(1,"testname","testname",18);

        FamilyMember savedMember = familyMemberRepo.save(familyMember);
        assertThat(familyMember.getFamilyId()).isEqualTo(savedMember.getFamilyId());
        assertThat(familyMember.getFamilyName()).isEqualTo(savedMember.getFamilyName());
        assertThat(familyMember.getGivenName()).isEqualTo(savedMember.getGivenName());
        assertThat(familyMember.getAge()).isEqualTo(savedMember.getAge());
    }

    @Test
    public void nullFamilyMember_ShouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    FamilyMember familyMember = null;
                    familyMemberRepo.save(familyMember);
                });
    }

    @Test
    public void nullFamilyId_ShouldThrowDbActionExecutionException(){
    assertThrows(DbActionExecutionException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(null,"testname","testname",18);
                    familyMemberRepo.save(familyMember);
                });
    }

    @Test
    public void nullFamilyName_ShouldThrowDbActionExecutionException(){
        assertThrows(DbActionExecutionException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,null,"testname",18);
                    familyMemberRepo.save(familyMember);
                });
    }

    @Test
    public void nullGivenName_ShouldThrowDbActionExecutionException(){
        assertThrows(DbActionExecutionException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"testname",null,18);
                    familyMemberRepo.save(familyMember);
                });
    }

    @Test
    public void nullAge_ShouldThrowDbActionExecutionException(){
        assertThrows(DbActionExecutionException.class,
                ()->{
                    FamilyMember familyMember = new FamilyMember(1,"testname","testname",null);
                    familyMemberRepo.save(familyMember);
                });
    }
}
