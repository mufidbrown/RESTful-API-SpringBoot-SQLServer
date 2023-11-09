package proyekmagang.restfullapi.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import proyekmagang.restfullapi.api.BaseResponse;
import proyekmagang.restfullapi.entity.User;
import proyekmagang.restfullapi.exception.DuplicateUserNameException;
import proyekmagang.restfullapi.exception.ResourceNotFoundException;
import proyekmagang.restfullapi.model.UserResponse;
import proyekmagang.restfullapi.repository.UserRepository;
import proyekmagang.restfullapi.service.ServiceUser;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, ServiceUser {

//    private final EntityManager entityManager;
//
//    @Override
//    public BaseResponse<?> testuser() {
//        Query query = entityManager.createNativeQuery("SELECT username, password from users u WHERE id = 2");
//        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
//        UserResponse userResponse = UserResponse.builder()
//                .username(list.get(0).toString())
//                .password(list.get(1).toString())
//                .build();
//        return BaseResponse.ok(userResponse);
//    }
//
//    @Override
//    public BaseResponse<?> testParameterUser(Integer idUser) {
//        Query query = entityManager.createNativeQuery("select username, password from users u WHERE id = ?1");
//        query.setParameter(1, idUser);
//        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
//        UserResponse userResponse = UserResponse.builder()
//                .username(list.get(0).toString())
//                .password(list.get(1).toString())
//                .build();
//        return BaseResponse.ok(userResponse);
//
//    }

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userId);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

//    @Override
//    public BaseResponse<?> testuser() {
//        return null;
//    }
//
//    @Override
//    public BaseResponse<?> testParameterUser(Integer idUser) {
//        return null;
//    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User createUser(User user) {
        if(user.getUserName() == null)
            throw new ResourceNotFoundException("Username is required", "Username", user.getUserName());

        if(user.getPassword() == null)
            throw new ResourceNotFoundException("Password is required", "Password", user.getPassword());

        User usr = userRepository.findByUserName(user.getUserName());
        if(usr != null)
            throw new DuplicateUserNameException("Username Already exists.");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
