package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.MovieDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;

import java.util.List;

public interface MovieService {

    public List<MovieDto> getAllMovies();
    public MovieDto addMovie(MovieDto movieDto);
    public MovieDto updateMovie(Integer movieId, MovieDto movieDto);
    public void deleteMovieById(Integer movieId);
    public MovieDto getMovieById(Integer movieId);
}
