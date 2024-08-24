package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.MovieDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.MovieRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovieDto> getAllMovies() {
        return this.modelMapper.map(movieRepo.findAll(), List.class);
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        Movie savedMovie = movieRepo.save(movie);
        return modelMapper.map(savedMovie, MovieDto.class);
    }

    @Override
    public MovieDto updateMovie(Integer movieId, MovieDto movieDto) {
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Theater with id " + movieId + " not found"));
        deleteMovieById(movieId);
        return modelMapper.map(movieRepo.save(movie), MovieDto.class);
    }

    @Override
    public void deleteMovieById(Integer movieId) {
        movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie with id " + movieId + " not found"));
        movieRepo.deleteById(movieId);
    }

    @Override
    public MovieDto getMovieById(Integer movieId) {
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie with id " + movieId + " not found"));
        return modelMapper.map(movie, MovieDto.class);
    }
}
