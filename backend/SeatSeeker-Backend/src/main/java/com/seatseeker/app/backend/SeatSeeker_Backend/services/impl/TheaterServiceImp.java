package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheaterDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Theater;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.TheaterRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheaterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImp implements TheaterService {

    @Autowired
    private TheaterRepo theaterRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TheaterDto createTheater(TheaterDto theaterDto) {
        Theater theater = this.modelMapper.map(theaterDto, Theater.class);
        Theater savedTheater = theaterRepo.save(theater);
        return this.modelMapper.map(savedTheater, TheaterDto.class);
    }

    @Override
    public TheaterDto updateTheater(Integer theaterId, TheaterDto theaterDto) {
        Theater theater = theaterRepo.findById(theaterId).orElseThrow(() -> new RuntimeException("Theater with id " + theaterId + " not found"));
        deleteTheaterById(theaterId);
        Theater savedTheater = theaterRepo.save(theater);
        return this.modelMapper.map(savedTheater, TheaterDto.class);
    }

    @Override
    public TheaterDto getTheaterById(Integer theaterId) {
        return this.modelMapper.map(theaterRepo.findById(theaterId).orElseThrow(() ->
                new RuntimeException("Theater with id " + theaterId + " not found")), TheaterDto.class);
    }

    @Override
    public List<TheaterDto> getAllTheaters() {
        return this.modelMapper.map(theaterRepo.findAll(), List.class);
    }

    @Override
    public void deleteTheaterById(Integer theaterId) {
        theaterRepo.findById(theaterId).orElseThrow(() -> new RuntimeException("Theater with id " + theaterId + " not found"));
        theaterRepo.deleteById(theaterId);
    }
}
