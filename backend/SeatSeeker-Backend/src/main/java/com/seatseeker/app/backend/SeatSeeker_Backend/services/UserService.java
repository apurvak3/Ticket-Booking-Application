package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User addNewUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userDao.save(user);
    }

    public User updateUser(User user) {
        return userDao.save(user);
    }

    public User findUserByEMail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        System.out.println(userDetails.getUsername());
        return userDao.findUserByEmail(userDetails.getUsername());
    }

    public void deleteUserByEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        userDao.deleteByEmail(userDetails.getUsername());
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
