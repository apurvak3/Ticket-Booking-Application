package com.seatseeker.app.backend.SeatSeeker_Backend.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
