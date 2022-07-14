package pl.myproject.Repositories;

import pl.myproject.Entities.Family;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FamilyRepo extends CrudRepository<Family,Integer> {

    @Query("SELECT MAX(id) FROM family;")
    Optional<Integer> getLastId();
}
