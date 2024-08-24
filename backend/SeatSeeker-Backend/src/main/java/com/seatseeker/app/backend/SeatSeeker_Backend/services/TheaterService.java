package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheaterDto;

import java.util.List;

public interface TheaterService {

    public TheaterDto createTheater(TheaterDto theaterDto);
    public TheaterDto updateTheater(Integer theaterId, TheaterDto theaterDto);
    public TheaterDto getTheaterById(Integer theaterId);
    public List<TheaterDto> getAllTheaters();
    public void deleteTheaterById(Integer theaterId);
}
