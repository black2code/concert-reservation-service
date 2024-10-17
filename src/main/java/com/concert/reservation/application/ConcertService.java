package com.concert.reservation.application;

import com.concert.reservation.domain.concert.ConcertRepository;
import com.concert.reservation.domain.seat.SeatRepository;
import com.concert.reservation.domain.seat.dto.AvailableSeatsResponse;
import com.concert.reservation.domain.seat.dto.SeatResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository, SeatRepository seatRepository) {
        this.concertRepository = concertRepository;
        this.seatRepository = seatRepository;
    }

    public List<LocalDate> getAvailableDates() {
        return IntStream.range(1, 4)
            .mapToObj(i -> LocalDate.now().plusDays(i))
            .collect(Collectors.toList());
    }

    public AvailableSeatsResponse getAvailableSeats(LocalDate date) {
        List<SeatResponse> seats = IntStream.range(1, 51)
            .mapToObj(i -> new SeatResponse(i, "AVAILABLE"))
            .collect(Collectors.toList());
        return new AvailableSeatsResponse(seats);
    }
}
