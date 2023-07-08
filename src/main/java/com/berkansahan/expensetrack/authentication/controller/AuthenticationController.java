package com.berkansahan.expensetrack.authentication.controller;

import com.berkansahan.expensetrack.authentication.service.AuthenticationService;
import com.berkansahan.expensetrack.authentication.dto.LoginRequest;
import com.berkansahan.expensetrack.authentication.dto.LoginResponse;
import com.berkansahan.expensetrack.authentication.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * Handles the registration request and returns the login response.
     *
     * @param request the register request containing user information
     * @return the login response containing authentication details
     */
    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * Handles the login request and returns the login response.
     *
     * @param request the login request containing user credentials
     * @return the login response containing authentication details
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }


}