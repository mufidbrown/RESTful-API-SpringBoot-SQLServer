package proyekmagang.restfullapi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import proyekmagang.restfullapi.entity.Product;
import org.springframework.web.multipart.MultipartFile;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.entity.Transaction;
import proyekmagang.restfullapi.entity.User;
import proyekmagang.restfullapi.model.TransactionRequest;
//import proyekmagang.restfullapi.repository.ProductRepository;
import proyekmagang.restfullapi.repository.ProductRepository;
import proyekmagang.restfullapi.repository.TransactionRepository;
import proyekmagang.restfullapi.repository.UserRepository;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    public Transaction findById(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }





    public Transaction createTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        User user = userRepository.findById(transactionRequest.getUserId()).
                orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(transactionRequest.getProductId()).
                orElseThrow(() -> new RuntimeException("Product not found"));
        transaction.setUser(user);
        transaction.setProduct(product);
        return transactionRepository.save(transaction);
    }



//        public List<Transaction> getTransactionsById() {
//        return transactionRepository.gById(id);
//    }

//        public Transaction findById(Long id) {
//
//    }



//    untuk upload excel
    public void saveTransactionsToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Product> products = ExcelUploadService.getProductsDataFromExcel(file.getInputStream());
                this.productRepository.saveAll(products);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    //    end upload excel




}

