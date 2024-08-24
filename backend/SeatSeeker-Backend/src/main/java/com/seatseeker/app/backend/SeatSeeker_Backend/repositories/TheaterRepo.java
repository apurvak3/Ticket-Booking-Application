package com.seatseeker.app.backend.SeatSeeker_Backend.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepo extends JpaRepository<Theater, Integer> {
}
