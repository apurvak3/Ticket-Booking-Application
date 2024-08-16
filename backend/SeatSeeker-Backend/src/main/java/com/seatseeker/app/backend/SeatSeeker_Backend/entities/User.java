package com.seatseeker.app.backend.SeatSeeker_Backend.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNo;
    private List<String> orderId;
    private List<String> roles;

}
