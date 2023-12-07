package proyekmagang.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyekmagang.restfullapi.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
