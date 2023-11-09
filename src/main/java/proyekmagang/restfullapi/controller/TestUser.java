//package proyekmagang.restfullapi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import proyekmagang.restfullapi.api.BaseResponse;
//import proyekmagang.restfullapi.service.ServiceUser;
//
//@RestController
//public class TestUser {
//
//    @Autowired
//    private ServiceUser serviceUser;
//
//    @GetMapping("/testuser")
//    public BaseResponse<?> testuser() {
//        return serviceUser.testuser();
//    }
//
//
//    @GetMapping("/testuser/v1/{id_user}")
//    public BaseResponse<?> testParameterUser(@PathVariable Integer id_user){
//        return serviceUser.testParameterUser(id_user);
//    }
//
//}
