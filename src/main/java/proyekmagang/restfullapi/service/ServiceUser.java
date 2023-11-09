package proyekmagang.restfullapi.service;

import proyekmagang.restfullapi.api.BaseResponse;
import proyekmagang.restfullapi.entity.User;

public interface ServiceUser {
//    BaseResponse<?> testuser();
//
//    BaseResponse<?> testParameterUser(Integer idUser);

    //JWT
    User findOne(String username);
    User createUser(User user);

}
