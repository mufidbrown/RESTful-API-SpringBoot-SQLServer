package proyekmagang.restfullapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }


    public Product updateProduct(Long id, Product product) {
            productRepository.save(product);
            return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
