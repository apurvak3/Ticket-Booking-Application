package com.seatseeker.app.backend.SeatSeeker_Backend.auth.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.RefreshToken;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
