package com.concert.reservation.domain.user.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BalanceChargeRequestDto {
    @Positive(message = "Amount must be positive")
    private double amount;
}
