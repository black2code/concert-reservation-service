package com.concert.reservation.api;

import com.concert.reservation.application.UserService;
import com.concert.reservation.domain.user.dto.BalanceChargeRequest;
import com.concert.reservation.domain.user.dto.BalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/balance/charge")
    public ResponseEntity<BalanceResponse> chargeBalance(@RequestHeader("Authorization") String token,
        @RequestBody BalanceChargeRequest request) {
        return ResponseEntity.ok(userService.chargeBalance(token, request.getAmount()));
    }

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponse> getBalance(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.getBalance(token));
    }
}
