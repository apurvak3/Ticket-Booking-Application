package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User addNewUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userDao.save(user);
    }

    public User updateUser(User user) {
        return userDao.save(user);
    }

    public User findUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userDao.findByUsername(username);
    }

    public void deleteUserUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        userDao.deleteByUsername(username);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
