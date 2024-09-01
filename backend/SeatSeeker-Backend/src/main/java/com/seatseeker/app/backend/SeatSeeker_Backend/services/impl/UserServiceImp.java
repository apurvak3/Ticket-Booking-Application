package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.UserDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.auth.models.UserRole;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.UserRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepo userRepo, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhoneNo(user.getPhoneNo());
        user.setOrderId(user.getOrderId());
        user.setRoles(UserRole.CUSTOMER);
        User userUpdated = this.userRepo.save(user);
        return this.modelMapper.map(userUpdated, UserDto.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        this.userRepo.delete(user);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).toList();
    }
}
