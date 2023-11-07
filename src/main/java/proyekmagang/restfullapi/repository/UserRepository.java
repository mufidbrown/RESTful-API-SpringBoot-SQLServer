package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
