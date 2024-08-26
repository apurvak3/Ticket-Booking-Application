package com.seatseeker.app.backend.SeatSeeker_Backend.Dto;

import lombok.Data;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Data
public class MovieDto {

    private Integer movieId;
    private String title;
    private List<String> language;
    private String genre;
    private String director;
    private String description;
    private Duration duration;
    private Date startDate;
    private Date endDate;
    private List<Integer> theatreIDs;
}
