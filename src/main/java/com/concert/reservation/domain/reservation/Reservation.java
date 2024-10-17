package com.concert.reservation.domain.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private String id;
    private String userId;
    private LocalDate concertDate;
    private int seatNumber;
    private LocalDateTime reservationTime;
    private String status;
}