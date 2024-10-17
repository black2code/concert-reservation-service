package com.concert.reservation.domain.seat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Long id;
    private int seatNumber;
    private String status;

    public Seat(int seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }
}
