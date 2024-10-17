package com.concert.reservation.domain.que.dto;

import lombok.Value;
@Value
public class QueueTokenResponse {
    String token;
    int queuePosition;
    int estimatedWaitTime;
}
