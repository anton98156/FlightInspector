package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FilterFlightsUntilNow implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (!flight.getSegments().isEmpty() && flight.getSegments().get(0).getDepartureDate().isAfter(now)) {
                result.add(flight);
            }
        }
        return result;
    }
}