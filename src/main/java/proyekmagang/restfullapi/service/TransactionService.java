package proyekmagang.restfullapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.entity.Product;
import proyekmagang.restfullapi.entity.Transaction;
import proyekmagang.restfullapi.entity.User;
import proyekmagang.restfullapi.model.TransactionRequest;
//import proyekmagang.restfullapi.repository.ProductRepository;
import proyekmagang.restfullapi.repository.ProductRepository;
import proyekmagang.restfullapi.repository.TransactionRepository;
import proyekmagang.restfullapi.repository.UserRepository;

import java.util.List;

@Service
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

}

