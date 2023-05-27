package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterIncorrectArrival implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            boolean hasIncorrectSegment = false;
            for (Segment segment : segments) {
                LocalDateTime departureDate = segment.getDepartureDate();
                LocalDateTime arrivalDate = segment.getArrivalDate();
                if (arrivalDate.isBefore(departureDate)) {
                    hasIncorrectSegment = true;
                    break;
                }
            }
            if (!hasIncorrectSegment) {
                result.add(flight);
            }
        }
        return result;
    }
}
