package com.berkansahan.expensetrack.authentication.security;

import com.berkansahan.expensetrack.authentication.dto.LoginRequest;
import com.berkansahan.expensetrack.authentication.dto.LoginResponse;
import com.berkansahan.expensetrack.authentication.dto.RegisterRequest;
import com.berkansahan.expensetrack.customer.UserRole;
import com.berkansahan.expensetrack.authentication.entity.Token;
import com.berkansahan.expensetrack.authentication.entity.TokenType;
import com.berkansahan.expensetrack.customer.User;
import com.berkansahan.expensetrack.authentication.entity.TokenRepository;
import com.berkansahan.expensetrack.customer.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author berkansahan
 * Authentication service that handles user registration and login.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Registers a new user and generates a JWT token for authentication.
     *
     * @param request the register request containing user information
     * @return the login response containing authentication details
     */
    public LoginResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(UserRole.ROLE_USER)
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return LoginResponse.builder()
                .token(jwtToken)
                .userId(savedUser.getId())
                .build();
    }

    /**
     * Authenticates a user and generates a new JWT token.
     *
     * @param request the login request containing user credentials
     * @return the login response containing authentication details
     */
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return LoginResponse.builder()
                .token(jwtToken)
                .userId(user.getId())
                .build();
    }

    /**
     * Saves the user token in the database.
     *
     * @param user     the user entity
     * @param jwtToken the JWT token to be saved
     */
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    /**
     * Revokes all existing valid tokens for the user.
     *
     * @param user the user entity
     */
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}
