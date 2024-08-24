package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("get-all")
    public List<TheatreDto> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTheatreById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(theatreService.getTheatreById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addTheatre(@RequestBody TheatreDto theatreDto) {
        return new ResponseEntity<>(theatreService.createTheatre(theatreDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTheatre(@PathVariable Integer id, @RequestBody TheatreDto theatreDto) {
        try {
            TheatreDto theatre = theatreService.updateTheatre(id, theatreDto);
            return new ResponseEntity<>(theatre, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable Integer id) {
        try {
            theatreService.deleteTheatreById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
