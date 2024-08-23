package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Data
public class MovieDto {

    private Integer id;
    private String title;
    private List<String> language;
    private String genre;
    private String director;
    private String description;
    private Duration duration;
    private Date startDate;
    private Date endDate;
}
