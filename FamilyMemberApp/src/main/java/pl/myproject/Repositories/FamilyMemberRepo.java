package pl.myproject.Repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.myproject.Entities.FamilyMember;

import java.util.List;
import java.util.Optional;

public interface FamilyMemberRepo extends CrudRepository<FamilyMember,Integer> {

    @Query("SELECT family_name,given_name,age FROM family_member WHERE family_id=:familyId")
    List<FamilyMember> findAllByFamilyId(@Param("familyId") Integer familyId);


}
