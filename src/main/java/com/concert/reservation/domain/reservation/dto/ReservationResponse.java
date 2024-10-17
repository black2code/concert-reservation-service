package com.concert.reservation.domain.reservation.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationResponse {
    private String reservationId;
    private LocalDateTime expirationTime;
}
