package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String orderId;
    private List<UserRole> roles;
}
