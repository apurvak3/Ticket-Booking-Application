package com.seatseeker.app.backend.SeatSeeker_Backend.auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogInRequest {

    private String username;
    private String password;
}
