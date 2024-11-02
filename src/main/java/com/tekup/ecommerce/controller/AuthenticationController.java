package com.tekup.ecommerce.controller;

import com.tekup.ecommerce.dto.JwtAuthenticationResponse;
import com.tekup.ecommerce.dto.RefreshTokenRequest;
import com.tekup.ecommerce.dto.SignUpRequest;
import com.tekup.ecommerce.dto.SignInRequest;
import com.tekup.ecommerce.entities.User;
import com.tekup.ecommerce.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        System.out.println("Received signup request: " + signUpRequest);
        User user = authenticationService.signup(signUpRequest);
        System.out.println("User created: " + user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signinRequest) {
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}

