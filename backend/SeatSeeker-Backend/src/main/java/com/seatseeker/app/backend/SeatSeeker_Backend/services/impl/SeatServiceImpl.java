package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.SeatDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Seat;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Theatre;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.SeatRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.SeatService;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {


    private SeatRepo seatRepo;
    private TheatreService theatreService;
    private ModelMapper modelMapper;

    public SeatServiceImpl(SeatRepo seatRepo, TheatreService theatreService, ModelMapper modelMapper) {
        this.seatRepo = seatRepo;
        this.theatreService = theatreService;
        this.modelMapper = modelMapper;
    }

    @Override
    public SeatDto createSeat(Integer theatreId, SeatDto seatDto) {
        TheatreDto theatreDto = theatreService.getTheatreById(theatreId);
        seatDto.setTheatreDto(theatreDto);
        Seat seat = modelMapper.map(seatDto, Seat.class);
        Seat createdSeat = seatRepo.save(seat);
        return modelMapper.map(createdSeat, SeatDto.class);
    }

    @Override
    public SeatDto updateSeat(Integer id, SeatDto seatDto) {
        deleteSeatById(id);
        Seat seat = modelMapper.map(seatDto, Seat.class);
        Seat createdSeat = seatRepo.save(seat);
        return modelMapper.map(createdSeat, SeatDto.class);
    }

    @Override
    public SeatDto getSeat(Integer id) {
        Seat seat = seatRepo.findById(id).orElseThrow(() -> new RuntimeException("Seat does not exist with id : " + id));
        return modelMapper.map(seat, SeatDto.class);
    }

    @Override
    public void deleteSeatById(Integer id) {
        seatRepo.findById(id).orElseThrow(() -> new RuntimeException("Seat does not exist with id : " + id));
        seatRepo.deleteById(id);
    }

    @Override
    public List<SeatDto> getAllSeats() {
        return modelMapper.map(seatRepo.findAll(), List.class);
    }
}
