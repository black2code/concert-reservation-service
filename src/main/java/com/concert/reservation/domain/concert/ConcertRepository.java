package com.concert.reservation.domain.concert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertRepository {

    private final Map<LocalDate, Concert> concerts = new ConcurrentHashMap<>();

    public void saveConcert(Concert concert) {
        concerts.put(concert.getDate(), concert);
    }

    public Concert getConcertByDate(LocalDate date) {
        return concerts.get(date);
    }

    public List<LocalDate> getAvailableDates() {
        return new ArrayList<>(concerts.keySet());
    }

    public void initializeData() {
        for (int i = 1; i <= 7; i++) {
            LocalDate date = LocalDate.now().plusDays(i);
            saveConcert(new Concert(date, "Concert " + i, 50));
        }
    }
}
