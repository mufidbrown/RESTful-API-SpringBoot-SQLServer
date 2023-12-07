package proyekmagang.restfullapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_users")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_products")
    private Product product;

    @CreationTimestamp
    private LocalDateTime transactionDate;
}
