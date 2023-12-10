package proyekmagang.restfullapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.exception.ResourceNotFoundException;
import proyekmagang.restfullapi.repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> allProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Integer id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPrice(updatedProduct.getPrice());
            // Set other fields if needed

            productRepository.save(existingProduct);
        }
    }

//    public Product updateProduct(Integer id, Product product) {
//        productRepository.save(product);
//        return product;
//    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }




//    public Product createProduct(Product product) {
//        productRepository.save(product);
//        return product;
//    }

}




