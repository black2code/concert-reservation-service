package com.concert.reservation.application;

import com.concert.reservation.domain.user.UserRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> chargeBalance(String token, double amount) {
        String userId = userRepository.getUserIdByToken(token);
        double newBalance = userRepository.chargeBalance(userId, amount);
        return Map.of(
            "userId", userId,
            "newBalance", newBalance
        );
    }

    public Map<String, Object> getBalance(String token) {
        String userId = userRepository.getUserIdByToken(token);
        double balance = userRepository.getBalance(userId);
        return Map.of(
            "userId", userId,
            "balance", balance
        );
    }
}
