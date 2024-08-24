package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TheatreDto {

    private Integer theatreId;
    private String name;
    private String city;
    private double ticketPrice;
    private List<SeatDto> seats;

}
