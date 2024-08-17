package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public String userLogin(@RequestBody User user) {
        System.out.println(user);
        return "SUCCESS";
    }

    @GetMapping
    public User getUser() {
        return userService.findUser();
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser() {
        userService.deleteUserUsername();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
