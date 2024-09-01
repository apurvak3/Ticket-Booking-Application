package com.seatseeker.app.backend.SeatSeeker_Backend.auth.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.AuthResponse;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.LogInRequest;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.RegisterRequest;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.UserRole;
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

    public AuthResponse userRegister(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNo(registerRequest.getPhoneNo())
                .roles(UserRole.CUSTOMER)
                .build();
        User savedUser = userRepo.save(user);
        var accessToken = jwtUtilService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getUsername());
        var name = user.getName();
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .name(name)
                .build();
    }
    public AuthResponse adminRegister(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNo(registerRequest.getPhoneNo())
                .roles(UserRole.ADMIN)
                .build();
        User savedUser = userRepo.save(user);
        var accessToken = jwtUtilService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getUsername());
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }

    public AuthResponse superAdminRegister(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNo(registerRequest.getPhoneNo())
                .roles(UserRole.SUPERADMIN)
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
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        var user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found "));
        var accessToken = jwtUtilService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(loginRequest.getEmail());
        var name = user.getName();

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .name(name)
                .build();
    }
}