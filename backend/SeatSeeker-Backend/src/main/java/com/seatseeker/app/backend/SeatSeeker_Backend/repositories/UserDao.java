package com.seatseeker.app.backend.SeatSeeker_Backend.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    public User findUserByEmail(String email);

    public void deleteByEmail(String email);
}
