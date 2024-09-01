package com.seatseeker.app.backend.SeatSeeker_Backend.auth.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private String name;
}
