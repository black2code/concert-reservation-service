package com.concert.reservation.domain.seat.dto;

import java.util.List;
import lombok.Value;

@Value
public class AvailableSeatsResponse {
    List<SeatResponse> availableSeats;
}
