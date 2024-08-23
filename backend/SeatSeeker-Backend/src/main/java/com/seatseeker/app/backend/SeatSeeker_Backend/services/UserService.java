package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.UserDto;

import java.util.List;

public interface UserService {

//    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    void deleteUser(Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
}
