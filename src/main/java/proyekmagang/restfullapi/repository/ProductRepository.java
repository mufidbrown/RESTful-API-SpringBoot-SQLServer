package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.entity.User;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
