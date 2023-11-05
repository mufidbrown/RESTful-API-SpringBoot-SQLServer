package proyekmagang.restfullapi.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proyekmagang.restfullapi.api.BaseResponse;
import proyekmagang.restfullapi.model.UserResponse;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements ServiceUser{

    private final EntityManager entityManager;

    @Override
    public BaseResponse<?> testuser() {
        Query query = entityManager.createNativeQuery("SELECT username, password from users u WHERE id = 2");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        UserResponse userResponse = UserResponse.builder()
                .username(list.get(0).toString())
                .password(list.get(1).toString())
                .build();
        return BaseResponse.ok(userResponse);
    }

    @Override
    public BaseResponse<?> testParameterUser(Integer idUser) {
        Query query = entityManager.createNativeQuery("select username, password from users u WHERE id = ?1");
        query.setParameter(1, idUser);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        UserResponse userResponse = UserResponse.builder()
                .username(list.get(0).toString())
                .password(list.get(1).toString())
                .build();
        return BaseResponse.ok(userResponse);

    }
}
