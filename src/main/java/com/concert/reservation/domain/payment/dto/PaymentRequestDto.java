package com.concert.reservation.domain.payment.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class PaymentRequestDto {
    @NotBlank(message = "Reservation ID cannot be blank")
    private String reservationId;
}
