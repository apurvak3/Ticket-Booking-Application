package com.seatseeker.app.backend.SeatSeeker_Backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seatNumber;
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    @JsonBackReference
    private Theatre theatre;
}
