package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.MovieDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("get-all")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Integer id) {
        try {
            MovieDto movie = movieService.getMovieById(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add")
    public MovieDto addMovie(@RequestBody MovieDto movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer id, @RequestBody MovieDto movie) {
        try {
            MovieDto movieToBeUpdate = movieService.updateMovie(id, movie);
            return new ResponseEntity<>(movieToBeUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        try {
            movieService.deleteMovieById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
