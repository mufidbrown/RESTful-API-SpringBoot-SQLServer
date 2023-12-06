package proyekmagang.restfullapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyekmagang.restfullapi.entity.Role;
import proyekmagang.restfullapi.entity.RoleEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
