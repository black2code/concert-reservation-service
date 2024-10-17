package com.concert.reservation.api;

import com.concert.reservation.application.ReservationService;
import com.concert.reservation.domain.reservation.dto.ReservationRequest;
import com.concert.reservation.domain.reservation.dto.ReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/concert-reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> reserveSeat(
        @RequestHeader("X-Queue-Token") String queueToken,
        @RequestBody ReservationRequest request) {
        return ResponseEntity.ok(reservationService.reserveSeat(queueToken, request));
    }
}
