package proyekmagang.restfullapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "excels")
public class Excel {

        @Id
        private Integer productId;
        private String productName;
        private Integer price;
        private Integer quantity;
        private String description;
}
