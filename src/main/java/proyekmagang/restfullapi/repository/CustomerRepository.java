package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
}
