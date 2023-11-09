package proyekmagang.restfullapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyekmagang.restfullapi.entity.User;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserCobaService userService;

//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers(){
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/user")
    ResponseEntity<?> createUser(@RequestBody User request) {
        User response = userService.createUser(request);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


//    @PostMapping("/add")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User updatedUser = userService.updateUser(id, user);
//        if (updatedUser != null) {
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/user/v1")
//    public ResponseEntity<BaseResponse<List<User>>> getAllUsers2() {
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua User", users));
//
//    }
//
//    @GetMapping("/user/v1/{id}")
//    public ResponseEntity<BaseResponse<User>> getUserById2(@PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return ResponseEntity.ok(BaseResponse.ok("User Ditemukan", user));
//        } else {
//            return ResponseEntity.ok(BaseResponse.error("User Tidak Ditemukan"));
//        }
//    }


}
