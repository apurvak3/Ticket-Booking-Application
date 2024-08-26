package com.seatseeker.app.backend.SeatSeeker_Backend.repositories;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
