package alim.togayev.blogapplication.identityservice.controller;

import alim.togayev.blogapplication.identityservice.entities.Token;
import alim.togayev.blogapplication.identityservice.entities.UserCredential;
import alim.togayev.blogapplication.identityservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public Token registerUser(@RequestBody UserCredential registerRequest) {
        System.out.println("REGISTER ENDPOINT HIT");
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public Token loginUser(@RequestBody UserCredential loginRequest) {
        return authService.authenticate(loginRequest);
    }

    @PostMapping("/validate")
    public boolean validateUser(@RequestBody Token token) {
        return authService.validateToken(token);
    }
}
