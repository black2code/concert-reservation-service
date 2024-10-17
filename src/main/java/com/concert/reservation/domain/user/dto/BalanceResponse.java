package com.concert.reservation.domain.user.dto;

import lombok.Value;
@Value
public class BalanceResponse {
    String userId;
    double balance;
}
