package proyekmagang.restfullapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        // Tambahkan produk ke dalam list products

        when(productService.allProducts()).thenReturn(products);

        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetProductById() throws Exception {
        int productId = 1;
        Product product = new Product();
        // Set nilai produk dengan ID yang sesuai

        when(productService.getProductById(productId)).thenReturn(product);

        mockMvc.perform(get("/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap());
    }

//    @Test
//    public void testAddProduct() throws Exception {
//        Product product = new Product();
//        // Set nilai produk yang akan ditambahkan
//
//        mockMvc.perform(post("/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(product)))
//                .andExpect(status().isCreated());
//
//        verify(productService, times(1)).addProduct(product);
//    }

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product(1, "ssd", 900, 1, "nvme");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isCreated());

        verify(productService, times(1)).addProduct(any(Product.class));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        int productId = 1;
        Product product = new Product();
        // Set nilai produk yang akan diupdate

        mockMvc.perform(put("/products/update/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isOk());

        verify(productService, times(1)).updateProduct(productId, product);
    }

    @Test
    public void testDeleteProduct() throws Exception {
        int productId = 1;

        mockMvc.perform(delete("/products/delete/{id}", productId))
                .andExpect(status().isOk());

        verify(productService, times(1)).deleteProduct(productId);
    }
}

