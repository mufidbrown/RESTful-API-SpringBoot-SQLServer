//package proyekmagang.restfullapi.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//import proyekmagang.restfullapi.dto.AuthenticationRequest;
//import proyekmagang.restfullapi.dto.AuthenticationResponse;
//import proyekmagang.restfullapi.util.JwtTokenProvider;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/api/auth")
//public class AuthController {
//
//
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(
//            @RequestBody AuthenticationRequest authenticationRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.createToken(authentication);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//
//    @GetMapping("/logout")
//    public ResponseEntity<?> logoutUser() {
//        SecurityContextHolder.clearContext();
//        return ResponseEntity.ok("Logout successful");
//    }
//
//
//}
