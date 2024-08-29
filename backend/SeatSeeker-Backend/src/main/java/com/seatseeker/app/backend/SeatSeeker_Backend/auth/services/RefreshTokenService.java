package com.seatseeker.app.backend.SeatSeeker_Backend.auth.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.RefreshToken;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.repositories.RefreshTokenRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepo refreshTokenRepo;
    private final UserRepo userRepo;

    public RefreshTokenService(RefreshTokenRepo refreshTokenRepo, UserRepo userRepo) {
        this.refreshTokenRepo = refreshTokenRepo;
        this.userRepo = userRepo;
    }

    public RefreshToken createRefreshToken(String username) {
        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with this username"));
        RefreshToken refreshToken = user.getRefreshToken();
        if (refreshToken == null) {
            long refreshTokenValidity = 60 * 60 * 1000;
            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expirationTime(Instant.now().plusMillis(refreshTokenValidity))
                    .user(user)
                    .build();
            refreshTokenRepo.save(refreshToken);
        }
        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {
        RefreshToken refToken = refreshTokenRepo.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Refresh token not found"));
        if (refToken.getExpirationTime().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(refToken);
            throw new RuntimeException("Refreshed token expired");
        }

        return refToken;
    }
}