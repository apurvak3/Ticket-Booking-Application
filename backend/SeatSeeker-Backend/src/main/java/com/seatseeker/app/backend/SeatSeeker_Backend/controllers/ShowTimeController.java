package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.ShowTimeDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.ShowTimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtime")
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }

    @PostMapping("/add-showtime")
    public ResponseEntity<ShowTimeDto> addShowTime(@RequestBody ShowTimeDto showTimeDto) {
        ShowTimeDto showTime = this.showTimeService.addShowTime(showTimeDto);
        return new ResponseEntity<>(showTime, HttpStatus.CREATED);
    }

    @PutMapping("/update-showtime/{showTimeId}")
    public ResponseEntity<ShowTimeDto> updateShowTime(@RequestBody ShowTimeDto showTimeDto, @PathVariable Integer showTimeId) {
        ShowTimeDto showTime = this.showTimeService.updateShowTime(showTimeDto, showTimeId);
        return new ResponseEntity<>(showTime, HttpStatus.OK);
    }

    @DeleteMapping("/delete-showtime/{showTimeId}")
    public ResponseEntity<?> deleteShowTime(@PathVariable Integer showTimeId) {
        this.showTimeService.deleteShowTime(showTimeId);
        return new ResponseEntity<>("ShowTime deleted successfully with id : " + showTimeId, HttpStatus.OK);
    }

    @GetMapping("/all-showtimes")
    public ResponseEntity<List<ShowTimeDto>> updateShowTime() {
        List<ShowTimeDto> showTime = this.showTimeService.getAllShowTime();
        return new ResponseEntity<>(showTime, HttpStatus.OK);
    }

}
