package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.MovieDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("get-all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie movieToBeUpdate = movieService.updateMovie(id, movie);
        if(movieToBeUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movieToBeUpdate, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        if(movieService.deleteMovieById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
