package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    public Movie updateMovie(Integer id, Movie movie) {
        if(deleteMovieById(id)) {
            return movieRepo.save(movie);
        }
        return null;
    }

    public boolean deleteMovieById(Integer id) {
        if(movieRepo.findById(id).isPresent()) {
            movieRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
