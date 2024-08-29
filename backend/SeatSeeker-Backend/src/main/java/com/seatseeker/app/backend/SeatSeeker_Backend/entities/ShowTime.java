package com.seatseeker.app.backend.SeatSeeker_Backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_time_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ticket_price", nullable = false)
    private Long ticketPrice;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "end_time", nullable = false)
    private String endTime;
    @ManyToOne
    @JoinColumn(name = "fk_movie_id")
    @JsonBackReference
    private Movie movie;
}
