package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;

import java.util.List;

public interface TheatreService {

    List<TheatreDto> getAllTheatres();
    TheatreDto getTheatreById(Integer id);
    TheatreDto addTheatre(TheatreDto theatreDto);
    TheatreDto updateTheatre(TheatreDto theatreDto, Integer id);
    void deleteTheatre(Integer id);
}
