package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}