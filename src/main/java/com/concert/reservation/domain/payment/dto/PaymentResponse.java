package com.concert.reservation.domain.payment.dto;

import lombok.Value;
@Value
public class PaymentResponse {
    String paymentId;
    String status;
    double amount;
}
