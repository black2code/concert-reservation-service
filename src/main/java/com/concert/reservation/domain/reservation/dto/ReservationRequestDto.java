package com.concert.reservation.domain.reservation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ReservationRequestDto {
    @NotNull(message = "Concert date cannot be null")
    private LocalDate concertDate;

    @Positive(message = "Seat number must be positive")
    private int seatNumber;
}
