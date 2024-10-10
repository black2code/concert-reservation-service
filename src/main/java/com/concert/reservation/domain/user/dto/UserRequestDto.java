package com.concert.reservation.domain.user.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserRequestDto {
    @NotBlank(message = "User ID cannot be blank")
    private String userId;
}
