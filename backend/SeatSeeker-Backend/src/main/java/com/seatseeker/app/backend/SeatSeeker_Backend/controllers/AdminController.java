package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
