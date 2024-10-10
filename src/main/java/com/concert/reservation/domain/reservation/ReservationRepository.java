package com.concert.reservation.domain.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();

    public Reservation save(String userId, LocalDate concertDate, int seatNumber) {
        String reservationId = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(reservationId, userId, concertDate, seatNumber, LocalDateTime.now(), "PENDING");
        reservations.put(reservationId, reservation);
        return reservation;
    }

    public Reservation getReservationById(String reservationId) {
        return reservations.get(reservationId);
    }

    public void updateStatus(String reservationId, String status) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            reservation.setStatus(status);
        }
    }

    public void deleteReservation(String reservationId) {
        reservations.remove(reservationId);
    }
}
