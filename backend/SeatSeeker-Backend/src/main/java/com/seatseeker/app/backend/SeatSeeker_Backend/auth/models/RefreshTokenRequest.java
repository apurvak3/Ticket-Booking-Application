package com.seatseeker.app.backend.SeatSeeker_Backend.auth.models;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}
