package com.tekup.ecommerce.services;

import com.tekup.ecommerce.dto.JwtAuthenticationResponse;
import com.tekup.ecommerce.dto.RefreshTokenRequest;
import com.tekup.ecommerce.dto.SignInRequest;
import com.tekup.ecommerce.dto.SignUpRequest;
import com.tekup.ecommerce.entities.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
