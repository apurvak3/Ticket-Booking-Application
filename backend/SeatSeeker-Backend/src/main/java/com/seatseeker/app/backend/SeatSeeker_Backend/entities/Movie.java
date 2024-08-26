package com.seatseeker.app.backend.SeatSeeker_Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "movie_table")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private List<String> language;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Duration duration;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_theatre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_id")
    )
    private Set<Theatre> theatres = new HashSet<>();

}
