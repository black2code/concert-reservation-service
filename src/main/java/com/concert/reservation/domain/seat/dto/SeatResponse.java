package com.concert.reservation.domain.seat.dto;


import lombok.Value;

@Value
public class SeatResponse {
    int seatNumber;
    String status;
}
