package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDto {

    private Integer id;
    private String name;
    private String location;
    private Long ticketPrice;
}
