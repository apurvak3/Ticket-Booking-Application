package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowTimeDto {
    private Integer id;
    private Long ticketPrice;
    private String startTime;
    private String endTime;
}
