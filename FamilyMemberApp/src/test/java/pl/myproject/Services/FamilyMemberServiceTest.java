package pl.myproject.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Exceptions.NoSuchFamilyIdException;
import pl.myproject.Repositories.FamilyMemberRepo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FamilyMemberServiceTest {

    @Mock
    private FamilyMemberRepo familyMemberRepo;

    @InjectMocks
    private FamilyMemberService familyMemberService;

    @Test
    void givenFamilyMember_whenSave_thenReturnFamilyMember(){
        FamilyMember familyMember = new FamilyMember(1,"testname","testname",18);

        given(familyMemberRepo.save(familyMember)).willReturn(familyMember);

        FamilyMember savedFamilyMember = familyMemberService.save(familyMember);
        assertThat(savedFamilyMember).isNotNull();
    }

    @Test
    void givenFamilyIdAndListOfMembers_whenFindAllByFamilyId_thenReturnMembersList(){

        FamilyMember familyMember = new FamilyMember(1,"testname","testname",18);
        List<FamilyMember> members=List.of(familyMember);

        given(familyMemberRepo.findAllByFamilyId(familyMember.getFamilyId())).willReturn(members);

        List<FamilyMember> testMembers = familyMemberService.findByFamilyId(familyMember.getFamilyId());
        assertThat(testMembers).isNotNull();
    }

    @Test
    void givenFamilyIdAndEmptyList_whenFindAllByFamilyId_thenThrowsNoSuchFamilyIdException(){

//        FamilyMember familyMember = new FamilyMember(1,"testname","testname",18);
        List<FamilyMember> members=List.of();
        Integer testFamilyId=1;
        given(familyMemberRepo.findAllByFamilyId(testFamilyId)).willReturn(members);

        assertThrows(NoSuchFamilyIdException.class,
                ()->{
                    List<FamilyMember> testMembers = familyMemberService.findByFamilyId(testFamilyId);
                });
    }
}
