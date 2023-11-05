package proyekmagang.restfullapi.service;

import proyekmagang.restfullapi.api.BaseResponse;

public interface ServiceUser {
    BaseResponse<?> testuser();

    BaseResponse<?> testParameterUser(Integer idUser);

}
