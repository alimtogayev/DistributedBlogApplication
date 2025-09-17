package alim.togayev.blogapplication.identityservice.service;

import alim.togayev.blogapplication.identityservice.entities.Token;
import alim.togayev.blogapplication.identityservice.entities.UserCredential;
import alim.togayev.blogapplication.identityservice.feign.UserInterface;
import alim.togayev.blogapplication.identityservice.repository.UserCredentialRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AuthService {
    private final UserCredentialRepo userCredentialRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserInterface userInterface;
    private final UserDetailsService userDetailsService;

    public Token authenticate(UserCredential credential) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credential.getUsername(),
                        credential.getPassword()
                )
        );
        var userCred = userCredentialRepo.findByUsername(credential.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(userCred);
        return Token.builder()
                .token(jwtToken)
                .build();
    }

    public Token register(UserCredential registerRequest) {
        var userCred = UserCredential.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userCredentialRepo.save(userCred);
        var jwtToken = jwtService.generateToken(userCred);
        userInterface.save(registerRequest.getUsername());
        return Token.builder()
                .token(jwtToken)
                .build();
    }

    public boolean validateToken(Token token) {
        return jwtService.isTokenValid(token.getToken(), userDetailsService.loadUserByUsername(token.getToken()));
    }
}
