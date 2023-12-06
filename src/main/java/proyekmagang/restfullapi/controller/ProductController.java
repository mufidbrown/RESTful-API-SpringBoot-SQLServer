//package proyekmagang.restfullapi.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import proyekmagang.restfullapi.entity.Product;
//import proyekmagang.restfullapi.service.ProductService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.allProducts();
//        return ResponseEntity.ok(products);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
//        Product product = productService.getProductById(id);
//        if (product != null) {
//            return ResponseEntity.ok(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
//        productService.addProduct(product);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
//        productService.updateProduct(id, product);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.ok().build();
//    }
//}
