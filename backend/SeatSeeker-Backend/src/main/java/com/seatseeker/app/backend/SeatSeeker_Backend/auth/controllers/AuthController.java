package com.seatseeker.app.backend.SeatSeeker_Backend.auth.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.*;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.services.JwtUtilService;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.services.RefreshTokenService;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.services.UserAuthService;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private final UserAuthService UserAuthService;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtilService jwtUtilService;

    public AuthController(UserAuthService UserAuthService, RefreshTokenService refreshTokenService, JwtUtilService jwtUtilService) {
        this.UserAuthService = UserAuthService;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtilService = jwtUtilService;
    }

    @PostMapping("/auth/user/signup")
    public ResponseEntity<AuthResponse> userRegister(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(UserAuthService.userRegister(registerRequest));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<AuthResponse> adminRegister(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(UserAuthService.adminRegister(registerRequest));
    }

    @PostMapping("/superAdmin/signup")
    public ResponseEntity<AuthResponse> superAdminRegister(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(UserAuthService.superAdminRegister(registerRequest));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LogInRequest loginRequest) {
        return ResponseEntity.ok(UserAuthService.login(loginRequest));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(request.getRefreshToken());
        User user = refreshToken.getUser();
        String accessToken = jwtUtilService.generateToken(user);
        return ResponseEntity.ok(AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build());
    }
}