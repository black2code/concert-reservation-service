package com.concert.reservation.application;

import com.concert.reservation.domain.user.UserRepository;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private final UserRepository userRepository;

    @Autowired
    public QueueService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> generateToken(String userId) {
        String token = UUID.randomUUID().toString();
        int queuePosition = new Random().nextInt(100) + 1;
        int estimatedWaitTime = new Random().nextInt(30) + 1;

        userRepository.saveToken(userId, token);

        return Map.of(
            "token", token,
            "queuePosition", queuePosition,
            "estimatedWaitTime", estimatedWaitTime
        );
    }
}
