package com.concert.reservation.api;

import com.concert.reservation.application.PaymentService;
import com.concert.reservation.domain.payment.dto.PaymentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<?> processPayment(@RequestHeader("Authorization") String token,
        @RequestBody PaymentRequestDto request) {
        return ResponseEntity.ok(paymentService.processPayment(token, request.getReservationId()));
    }
}
