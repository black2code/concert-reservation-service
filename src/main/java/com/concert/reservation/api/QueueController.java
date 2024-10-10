package com.concert.reservation.api;

import com.concert.reservation.application.QueueService;
import com.concert.reservation.domain.user.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    private final QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/token")
    public ResponseEntity<?> getQueueToken(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(queueService.generateToken(request.getUserId()));
    }
}
