package com.seatseeker.app.backend.SeatSeeker_Backend.auth.models;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String text) {
}
