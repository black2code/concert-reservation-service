package com.concert.reservation.api;

import com.concert.reservation.application.ConcertService;
import com.concert.reservation.domain.seat.dto.AvailableSeatsResponse;
import com.concert.reservation.domain.seat.dto.SeatResponse;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {
    private final ConcertService concertService;

    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping("/available-dates")
    public ResponseEntity<List<LocalDate>> getAvailableDates() {
        return ResponseEntity.ok(concertService.getAvailableDates());
    }

    @GetMapping("/available-seats")
    public ResponseEntity<AvailableSeatsResponse> getAvailableSeats(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(concertService.getAvailableSeats(date));
    }
}
