package com.concert.reservation.domain.seat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Repository;

@Repository
public class SeatRepository {

    private final Map<LocalDate, Map<Integer, Seat>> seats = new ConcurrentHashMap<>();

    public void initializeSeats(LocalDate date, int totalSeats) {
        Map<Integer, Seat> concertSeats = IntStream.rangeClosed(1, totalSeats)
            .boxed()
            .collect(Collectors.toConcurrentMap(
                i -> i,
                i -> new Seat(i, "AVAILABLE")
            ));
        seats.put(date, concertSeats);
    }

    public List<Seat> getAvailableSeats(LocalDate date) {
        return seats.getOrDefault(date, Map.of()).values().stream()
            .filter(seat -> "AVAILABLE".equals(seat.getStatus()))
            .collect(Collectors.toList());
    }

    public boolean reserveSeat(LocalDate date, int seatNumber) {
        Map<Integer, Seat> concertSeats = seats.get(date);
        if (concertSeats != null) {
            Seat seat = concertSeats.get(seatNumber);
            if (seat != null && "AVAILABLE".equals(seat.getStatus())) {
                seat.setStatus("RESERVED");
                return true;
            }
        }
        return false;
    }

    public void releaseSeat(LocalDate date, int seatNumber) {
        Map<Integer, Seat> concertSeats = seats.get(date);
        if (concertSeats != null) {
            Seat seat = concertSeats.get(seatNumber);
            if (seat != null) {
                seat.setStatus("AVAILABLE");
            }
        }
    }
}
