package com.concert.reservation.domain.payment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
