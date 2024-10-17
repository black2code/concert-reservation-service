package com.concert.reservation.application;

import com.concert.reservation.domain.concert.ConcertRepository;
import com.concert.reservation.domain.seat.SeatRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository, SeatRepository seatRepository) {
        this.concertRepository = concertRepository;
        this.seatRepository = seatRepository;
    }

    public Map<String, List<String>> getAvailableDates() {
        List<String> dates = IntStream.range(1, 4)
            .mapToObj(i -> LocalDate.now().plusDays(i).toString())
            .collect(Collectors.toList());
        return Map.of("availableDates", dates);
    }

    public Map<String, List<Map<String, Object>>> getAvailableSeats(String date) {
        List<Map<String, Object>> seats = IntStream.range(1, 51)
            .mapToObj(i -> {
                Map<String, Object> seat = Map.of(
                    "seatNumber", Integer.valueOf(i),
                    "status", "AVAILABLE"
                );
                return seat;
            })
            .collect(Collectors.toList());
        return Map.of("availableSeats", seats);
    }
}
