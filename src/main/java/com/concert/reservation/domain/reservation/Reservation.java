package com.concert.reservation.domain.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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