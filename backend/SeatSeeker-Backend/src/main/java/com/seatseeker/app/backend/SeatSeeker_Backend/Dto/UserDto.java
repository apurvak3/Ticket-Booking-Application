package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer userId;
    private String username;
    private String email;
    private String password;
    private String phoneNo;
    private Date createdAt;
    private String orderId;
}
