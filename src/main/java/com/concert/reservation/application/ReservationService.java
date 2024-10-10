package com.concert.reservation.application;

import com.concert.reservation.domain.reservation.ReservationRepository;
import com.concert.reservation.domain.reservation.dto.ReservationRequestDto;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Map<String, Object> reserveSeat(String token, ReservationRequestDto request) {
        String reservationId = UUID.randomUUID().toString();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(5);

        reservationRepository.save(reservationId, request.getConcertDate(), request.getSeatNumber());

        return Map.of(
            "reservationId", reservationId,
            "expirationTime", expirationTime.toString()
        );
    }
}
