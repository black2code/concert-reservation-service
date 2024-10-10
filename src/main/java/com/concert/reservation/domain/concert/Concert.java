package com.concert.reservation.domain.concert;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Concert {
    private Long id;
    private LocalDate date;
    private String name;
    private int totalSeats;

    public Concert(LocalDate date, String name, int totalSeats) {
        this.date = date;
        this.name = name;
        this.totalSeats = totalSeats;
    }
}
