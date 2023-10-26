package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
