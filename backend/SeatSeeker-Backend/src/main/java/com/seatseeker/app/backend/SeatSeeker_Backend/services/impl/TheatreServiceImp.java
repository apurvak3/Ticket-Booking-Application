package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Theatre;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.TheatreRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImp implements TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) {
        Theatre theatre = this.modelMapper.map(theatreDto, Theatre.class);
        Theatre savedTheatre = theatreRepo.save(theatre);
        return this.modelMapper.map(savedTheatre, TheatreDto.class);
    }

    @Override
    public TheatreDto updateTheatre(Integer theatreId, TheatreDto theatreDto) {
        Theatre theatre = theatreRepo.findById(theatreId).orElseThrow(() -> new RuntimeException("Theatre with id " + theatreId + " not found"));
        deleteTheatreById(theatreId);
        Theatre savedTheatre = theatreRepo.save(theatre);
        return this.modelMapper.map(savedTheatre, TheatreDto.class);
    }

    @Override
    public TheatreDto getTheatreById(Integer theatreId) {
        return this.modelMapper.map(theatreRepo.findById(theatreId).orElseThrow(() ->
                new RuntimeException("Theatre with id " + theatreId + " not found")), TheatreDto.class);
    }

    @Override
    public List<TheatreDto> getAllTheatres() {
        return this.modelMapper.map(theatreRepo.findAll(), List.class);
    }

    @Override
    public void deleteTheatreById(Integer theatreId) {
        theatreRepo.findById(theatreId).orElseThrow(() -> new RuntimeException("Theatre with id " + theatreId + " not found"));
        theatreRepo.deleteById(theatreId);
    }
}
