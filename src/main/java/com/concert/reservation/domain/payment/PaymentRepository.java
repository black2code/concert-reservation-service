package com.concert.reservation.domain.payment;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    private final Map<String, Payment> payments = new ConcurrentHashMap<>();

    public Payment save(String userId, String reservationId, double amount) {
        String paymentId = UUID.randomUUID().toString();
        Payment payment = new Payment(paymentId, userId, reservationId, amount, LocalDateTime.now(), "SUCCESS");
        payments.put(paymentId, payment);
        return payment;
    }

    public Payment getPaymentById(String paymentId) {
        return payments.get(paymentId);
    }

    public Payment getPaymentByReservationId(String reservationId) {
        return payments.values().stream()
            .filter(payment -> payment.getReservationId().equals(reservationId))
            .findFirst()
            .orElse(null);
    }
}
