package com.concert.reservation.api;

import com.concert.reservation.application.ReservationService;
import com.concert.reservation.domain.reservation.dto.ReservationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<?> reserveSeat(@RequestHeader("Authorization") String token,
        @RequestBody ReservationRequestDto request) {
        return ResponseEntity.ok(reservationService.reserveSeat(token, request));
    }
}
