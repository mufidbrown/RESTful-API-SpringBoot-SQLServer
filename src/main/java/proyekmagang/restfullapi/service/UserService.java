package proyekmagang.restfullapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyekmagang.restfullapi.entity.User;
import proyekmagang.restfullapi.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(Long id, User user) {
            userRepository.save(user);
            return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

