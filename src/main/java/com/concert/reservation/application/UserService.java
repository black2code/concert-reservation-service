package com.concert.reservation.application;

import com.concert.reservation.domain.user.UserRepository;
import com.concert.reservation.domain.user.dto.BalanceResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BalanceResponse chargeBalance(String token, double amount) {
        String userId = userRepository.getUserIdByToken(token);
        double newBalance = userRepository.chargeBalance(userId, amount);
        return new BalanceResponse(userId, newBalance);
    }

    public BalanceResponse getBalance(String token) {
        String userId = userRepository.getUserIdByToken(token);
        double balance = userRepository.getBalance(userId);
        return new BalanceResponse(userId, balance);
    }
}
