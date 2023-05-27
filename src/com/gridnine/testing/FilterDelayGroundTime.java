package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterDelayGroundTime implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean valid = true;
            List<Segment> segments = flight.getSegments();
            Duration groundTime = Duration.ZERO;
            for (int i = 0; i < segments.size() - 1; i++) {
                Segment currentSegment = segments.get(i);
                Segment nextSegment = segments.get(i + 1);
                groundTime = groundTime.plus(Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()));
            }
            if (groundTime.toHours() > 2) {
                valid = false;
            }
            else if (valid) {
                result.add(flight);
            }
        }
        return result;
    }
}