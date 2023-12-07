package proyekmagang.restfullapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("testGetAll")
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
    @DisplayName("testGetById")
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



    @Test
    @DisplayName("testCreate")
    public void testAddProduct() throws Exception {
        Product product = new Product(1, "ssd", 900, 1, "nvme");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isCreated());

        verify(productService, times(1)).addProduct(any(Product.class));
    }


    @Test
    @DisplayName("testUpdateById")
    public void testUpdateProduct() throws Exception {
        int productId = 1;
        Product updatedProduct = new Product(1, "ssd", 1800,  2, "nvme 256gb");

        mockMvc.perform(put("/products/update/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedProduct)))
                .andExpect(status().isOk());

        verify(productService, times(1)).updateProduct(eq(productId), any(Product.class));
    }

//    @Test
//    void updateProduct() throws Exception {
//        Product product = new Product(1, "ssd", 1800,  2, "nvme 256gb");
//
//        mockMvc.perform(put("/products/update/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(product)))
//                .andExpect(status().isOk());
//
//        verify(productService, times(1)).updateProduct(1, product);
//        verifyNoMoreInteractions(productService);
//    }

//    @Test
//    public void testUpdateUser() throws Exception{
//        Product input = new Product(1, "ssd", 1800,  2, "nvme 256gb");
//        Product returned = new Product(1, "ssd_updated", 1800, 2, "nvme 256gb");
//        //stub the data
//        when(productService.updateProduct(1,input)).thenReturn(returned);
//
//        //original method call
//        Product result = productController.updateProduct(1,input).getBody();
//
//        Assert.assertEquals(result.getProductName(), "ssd_updated");
//    }

//    @Test
//    public void testUpdateProduct() throws Exception {
//        int productId = 1;
//        Product product = new Product();
//        // Set nilai produk yang akan diupdate
//
//        mockMvc.perform(put("/products/update/{id}", productId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(product)))
//                .andExpect(status().isOk());
//
//        verify(productService, times(1)).updateProduct(productId, product);
//    }

    @Test
    @DisplayName("testDelete")
    public void testDeleteProduct() throws Exception {
        int productId = 1;

        mockMvc.perform(delete("/products/delete/{id}", productId))
                .andExpect(status().isOk());

        verify(productService, times(1)).deleteProduct(productId);
    }
}

