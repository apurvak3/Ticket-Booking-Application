package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.Data;

@Data
public class SeatDto {

    Integer seatId;
    String seatNumber;
    boolean isBooked;

    TheatreDto theatreDto;
}
