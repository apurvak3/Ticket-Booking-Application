package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public User getUser() {
        return userService.findUserByEMail();
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser() {
        userService.deleteUserByEmail();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
