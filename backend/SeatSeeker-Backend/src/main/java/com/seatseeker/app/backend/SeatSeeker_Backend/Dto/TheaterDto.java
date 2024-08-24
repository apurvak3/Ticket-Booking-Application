package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TheaterDto {

    private Integer TheaterId;
    private String name;
    private String city;
    private double ticketPrice;
    private List<SeatDto> seats;

}
