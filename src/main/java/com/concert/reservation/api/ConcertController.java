package com.concert.reservation.api;

import com.concert.reservation.application.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {

    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping("/available-dates")
    public ResponseEntity<?> getAvailableDates() {
        return ResponseEntity.ok(concertService.getAvailableDates());
    }

    @GetMapping("/{date}/available-seats")
    public ResponseEntity<?> getAvailableSeats(@PathVariable String date) {
        return ResponseEntity.ok(concertService.getAvailableSeats(date));
    }
}
