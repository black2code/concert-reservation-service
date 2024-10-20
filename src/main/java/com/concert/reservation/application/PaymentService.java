package com.concert.reservation.application;

import com.concert.reservation.domain.payment.PaymentRepository;
import com.concert.reservation.domain.payment.dto.PaymentResponse;
import com.concert.reservation.domain.reservation.ReservationRepository;
import com.concert.reservation.domain.user.UserRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public PaymentService(PaymentRepository paymentRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public PaymentResponse processPayment(String token, String reservationId) {
        String userId = userRepository.getUserIdByToken(token);
        double amount = 100.0;

        if (userRepository.getBalance(userId) < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        userRepository.deductBalance(userId, amount);
        String paymentId = UUID.randomUUID().toString();
        paymentRepository.save(userId, reservationId, amount);
        reservationRepository.updateStatus(reservationId, "PAID");

        return new PaymentResponse(paymentId, "SUCCESS", amount);
    }
}
