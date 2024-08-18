package com.seatseeker.app.backend.SeatSeeker_Backend.auth.models;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "refresh_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String refreshToken;
    private Instant expirationTime;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
