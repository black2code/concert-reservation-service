package com.concert.reservation.domain.payment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String id;
    private String userId;
    private String reservationId;
    private double amount;
    private LocalDateTime paymentTime;
    private String status;
}
