package com.concert.reservation.application;

import com.concert.reservation.domain.reservation.ReservationRepository;
import com.concert.reservation.domain.reservation.dto.ReservationRequest;
import com.concert.reservation.domain.reservation.dto.ReservationResponse;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponse reserveSeat(String token, ReservationRequest request) {
        String reservationId = UUID.randomUUID().toString();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(5);

        reservationRepository.save(reservationId, request.getConcertDate(), request.getSeatNumber());

        return ReservationResponse.builder()
            .reservationId(reservationId)
            .expirationTime(expirationTime)
            .build();
    }
}
