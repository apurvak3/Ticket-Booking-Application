package com.seatseeker.app.backend.SeatSeeker_Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "theatre_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theatreId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private double ticketPrice;
    @Column(nullable = false)
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;
    @ManyToMany
    @JoinTable(name = "movie_theatre",
    joinColumns = @JoinColumn(name = "theatre_id"),
            inverseJoinColumns = @JoinColumn(name = "moive_id")
    )
    private Set<Movie> movies = new HashSet<>();
}
