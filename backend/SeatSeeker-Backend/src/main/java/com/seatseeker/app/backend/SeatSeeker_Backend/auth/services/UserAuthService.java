package com.seatseeker.app.backend.SeatSeeker_Backend.auth.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.AuthResponse;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.LogInRequest;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.RegisterRequest;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtUtilService jwtUtilService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

    public UserAuthService(PasswordEncoder passwordEncoder, UserRepo userRepo, JwtUtilService jwtUtilService, RefreshTokenService refreshTokenService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.jwtUtilService = jwtUtilService;
        this.refreshTokenService = refreshTokenService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNo(registerRequest.getPhoneNo())
                .build();
        User savedUser = userRepo.save(user);
        var accessToken = jwtUtilService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getUsername());
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }

    public AuthResponse login(LogInRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        var user = userRepo.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found "));
        var accessToken = jwtUtilService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(loginRequest.getUsername());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }
}