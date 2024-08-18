package com.seatseeker.app.backend.SeatSeeker_Backend.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
