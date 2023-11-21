package proyekmagang.restfullapi.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false)
        private Integer id;

        @Column(nullable = false)
        private String productName;

        @Column(nullable = false)
        private double price;


        // constructors, getters, setters, and other methods

        public Integer getId() {
            return id;
        }

        public Product setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getProductName() {
            return productName;
        }

        public Product setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public double getPrice() {
            return price;
        }

        public Product setPrice(double price) {
            this.price = price;
            return this;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", productName='" + productName + '\'' +
                    ", price=" + price +
                    '}';
        }
    }


