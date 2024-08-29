package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.ShowTimeDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Movie;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.ShowTime;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.MovieRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.ShowTimeRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.ShowTimeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    private final ShowTimeRepo showTimeRepo;
    private final MovieRepo movieRepo;
    private final ModelMapper modelMapper;

    public ShowTimeServiceImpl(ShowTimeRepo showTimeRepo,MovieRepo movieRepo, ModelMapper modelMapper) {
        this.showTimeRepo = showTimeRepo;
        this.movieRepo = movieRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShowTimeDto addShowTime(ShowTimeDto showTimeDto, Integer movieId) {
        ShowTime showTime = this.modelMapper.map(showTimeDto, ShowTime.class);
        Movie movie = this.movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found with id: " + movieId));
        showTime.setMovie(movie);
        ShowTime savedShowTime = this.showTimeRepo.save(showTime);
        return this.modelMapper.map(savedShowTime, ShowTimeDto.class);
    }

    @Override
    public ShowTimeDto updateShowTime(ShowTimeDto showTimeDto, Integer showTimeId) {
        ShowTime showTime = this.showTimeRepo.findById(showTimeId).orElseThrow(() -> new RuntimeException("ShowTime not found with id " + showTimeId));
        showTime.setTicketPrice(showTimeDto.getTicketPrice());
        showTime.setStartTime(showTime.getStartTime());
        showTime.setEndTime(showTime.getEndTime());
        ShowTime updatedShowTime = this.showTimeRepo.save(showTime);
        return this.modelMapper.map(updatedShowTime, ShowTimeDto.class);
    }

    @Override
    public void deleteShowTime(Integer showTimeId) {
        ShowTime showTime = this.showTimeRepo.findById(showTimeId).orElseThrow(() -> new RuntimeException("ShowTime not found with id " + showTimeId));
        this.showTimeRepo.delete(showTime);
    }

    @Override
    public List<ShowTimeDto> getAllShowTime() {
        List<ShowTime> showTimes = this.showTimeRepo.findAll();
        return showTimes.stream().map(showTime -> this.modelMapper.map(showTime, ShowTimeDto.class)).toList();
    }
}
