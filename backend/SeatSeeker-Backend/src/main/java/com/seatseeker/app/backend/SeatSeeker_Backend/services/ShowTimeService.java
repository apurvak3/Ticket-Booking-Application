package com.seatseeker.app.backend.SeatSeeker_Backend.services;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.ShowTimeDto;

import java.util.List;

public interface ShowTimeService {

    ShowTimeDto addShowTime(ShowTimeDto showTimeDto, Integer movieId);
    ShowTimeDto updateShowTime(ShowTimeDto showTimeDto, Integer showTimeId);
    void deleteShowTime(Integer showTimeId);
    List<ShowTimeDto> getAllShowTime();
}
