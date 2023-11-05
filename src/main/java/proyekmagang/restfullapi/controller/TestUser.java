package proyekmagang.restfullapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyekmagang.restfullapi.api.BaseResponse;
import proyekmagang.restfullapi.service.ServiceUser;

@RestController
public class TestUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/testuser")
    public BaseResponse<?> testuser() {
        return serviceUser.testuser();
    }

}
