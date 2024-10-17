package com.concert.reservation.domain.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final Map<String, String> userTokens = new ConcurrentHashMap<>();
    private final Map<String, Double> userBalances = new ConcurrentHashMap<>();

    public void saveToken(String userId, String token) {
        userTokens.put(userId, token);
    }

    public boolean tokenExists(String token) {
        return userTokens.containsValue(token);
    }

    public String getUserIdByToken(String token) {
        for (Map.Entry<String, String> entry : userTokens.entrySet()) {
            if (entry.getValue().equals(token)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public double getBalance(String userId) {
        return userBalances.getOrDefault(userId, 0.0);
    }

    public double chargeBalance(String userId, double amount) {
        double newBalance = userBalances.getOrDefault(userId, 0.0) + amount;
        userBalances.put(userId, newBalance);
        return newBalance;
    }

    public void deductBalance(String userId, double amount) {
        double currentBalance = userBalances.getOrDefault(userId, 0.0);
        if (currentBalance < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        userBalances.put(userId, currentBalance - amount);
    }
}
