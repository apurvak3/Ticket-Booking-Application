package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;

import java.util.List;

public interface TheatreService {

    public TheatreDto createTheatre(TheatreDto theatreDto);
    public TheatreDto updateTheatre(Integer theatreId, TheatreDto theatreDto);
    public TheatreDto getTheatreById(Integer theatreId);
    public List<TheatreDto> getAllTheatres();
    public void deleteTheatreById(Integer theatreId);
}
