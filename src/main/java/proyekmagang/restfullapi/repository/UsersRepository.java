package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);

}
