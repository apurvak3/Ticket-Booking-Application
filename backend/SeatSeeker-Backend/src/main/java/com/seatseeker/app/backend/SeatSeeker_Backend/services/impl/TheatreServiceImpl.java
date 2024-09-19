package com.seatseeker.app.backend.SeatSeeker_Backend.services.impl;

import com.seatseeker.app.backend.SeatSeeker_Backend.Dto.TheatreDto;
import com.seatseeker.app.backend.SeatSeeker_Backend.entities.Theatre;
import com.seatseeker.app.backend.SeatSeeker_Backend.repositories.TheatreRepo;
import com.seatseeker.app.backend.SeatSeeker_Backend.services.TheatreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {

    private final ModelMapper modelMapper;
    private final TheatreRepo theatreRepo;

    @Override
    public TheatreDto addTheatre(TheatreDto theatreDto) {
        Theatre theatre = modelMapper.map(theatreDto, Theatre.class);
        Theatre savedTheatre = theatreRepo.save(theatre);
        return modelMapper.map(savedTheatre, TheatreDto.class);
    }

    @Override
    public TheatreDto updateTheatre(TheatreDto theatreDto, Integer id) {
       Theatre theatre = theatreRepo.findById(id).orElseThrow();
       Theatre updatedTheatre = theatre.builder()
               .id(theatreDto.getId())
               .name(theatreDto.getName())
               .location(theatreDto.getLocation())
               .ticketPrice(theatreDto.getTicketPrice())
               .build();
         Theatre savedTheatre = theatreRepo.save(updatedTheatre);
         return modelMapper.map(savedTheatre, TheatreDto.class);
    }

    @Override
    public void deleteTheatre(Integer id) {
        Theatre theatre = theatreRepo.findById(id).orElseThrow();
        theatreRepo.delete(theatre);
    }

    @Override
    public List<TheatreDto> getAllTheatres() {
        List<Theatre> theatres = theatreRepo.findAll();
        List<TheatreDto> theatreDtos = theatres.stream().map(theatre -> modelMapper.map(theatre, TheatreDto.class)).toList();
        return theatreDtos;
    }

    @Override
    public TheatreDto getTheatreById(Integer id) {
        Theatre theatre = theatreRepo.findById(id).orElseThrow();
        return modelMapper.map(theatre, TheatreDto.class);
    }

}
