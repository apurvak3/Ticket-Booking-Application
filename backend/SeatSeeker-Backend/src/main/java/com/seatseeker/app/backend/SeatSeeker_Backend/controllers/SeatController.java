package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.SeatDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("add/{theatreId}")
    public SeatDto addSeat(@PathVariable Integer theatreId, @RequestBody SeatDto seatDto) {
        return seatService.createSeat(theatreId, seatDto);
    }

    @PutMapping("{id}")
    public SeatDto updateSeat(@PathVariable Integer id, @RequestBody SeatDto seatDto) {
        return seatService.updateSeat(id, seatDto);
    }

    @DeleteMapping("{id}")
    public void deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeatById(id);
    }

    @GetMapping("{id}")
    public SeatDto getSeat(@PathVariable Integer id) {
        return seatService.getSeat(id);
    }

    @GetMapping("get-all")
    public List<SeatDto> getAllSeats() {
        return seatService.getAllSeats();
    }
}
