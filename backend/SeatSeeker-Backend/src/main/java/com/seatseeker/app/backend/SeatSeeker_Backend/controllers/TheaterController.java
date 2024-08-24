package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheaterDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("get-all")
    public List<TheaterDto> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTheaterById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(theaterService.getTheaterById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addTheater(@RequestBody TheaterDto theaterDto) {
        return new ResponseEntity<>(theaterService.createTheater(theaterDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTheater(@PathVariable Integer id, @RequestBody TheaterDto theaterDto) {
        try {
            TheaterDto theater = theaterService.updateTheater(id, theaterDto);
            return new ResponseEntity<>(theater, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTheater(@PathVariable Integer id) {
        try {
            theaterService.deleteTheaterById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
