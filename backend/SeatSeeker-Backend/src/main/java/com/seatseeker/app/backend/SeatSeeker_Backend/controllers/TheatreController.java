package com.seatseeker.app.backend.SeatSeeker_Backend.controllers;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @GetMapping("/get-all")
    public ResponseEntity<List<TheatreDto>> getAllTheatres() {
        List<TheatreDto> theatreDtos = theatreService.getAllTheatres();
        return new ResponseEntity<>(theatreDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreDto> getTheatreById(@PathVariable Integer id) {
        TheatreDto theatre = this.theatreService.getTheatreById(id);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto) {
        TheatreDto theatre = this.theatreService.addTheatre(theatreDto);
        return new ResponseEntity<>(theatre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheatreDto> updateTheatre(@RequestBody TheatreDto theatreDto, @PathVariable Integer id) {
        TheatreDto theatre = theatreService.updateTheatre(theatreDto, id);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable Integer id) {
        theatreService.deleteTheatre(id);
        return new ResponseEntity<>("Record deleted successfully !", HttpStatus.OK);
    }

}
