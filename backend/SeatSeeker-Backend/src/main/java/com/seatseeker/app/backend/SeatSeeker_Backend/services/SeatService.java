package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.SeatDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Seat;

import java.util.List;

public interface SeatService {

    public SeatDto createSeat(Integer theatreId, SeatDto seatDto);
    public SeatDto updateSeat(Integer id, SeatDto seatDto);
    public SeatDto getSeat(Integer id);
    public List<SeatDto> getAllSeats();
    public void deleteSeatById(Integer id);
}
