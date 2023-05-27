package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> primaryFlights = FlightBuilder.createFlights();
        System.out.println("\nТестовый набор перелётов до фильтрации: \n" + primaryFlights);

        System.out.println("\nФильтрация вылета до текущего момента времени:");
        FilterCollection filtrationFlightsUntilNow = new FilterCollection();
        filtrationFlightsUntilNow.addFilter(new FilterFlightsUntilNow());
        System.out.println(filtrationFlightsUntilNow.filter(primaryFlights));

        System.out.println("\nФильтрация по дате прилёта раньше даты вылета:");
        FilterCollection filtrationIncorrectArrival = new FilterCollection();
        filtrationIncorrectArrival.addFilter(new FilterIncorrectArrival());
        System.out.println(filtrationIncorrectArrival.filter(primaryFlights));

        System.out.println("\nФильтрация превышающих время на земле:");
        FilterCollection filtrationDelayGroundTime = new FilterCollection();
        filtrationDelayGroundTime.addFilter(new FilterDelayGroundTime());
        System.out.println(filtrationDelayGroundTime.filter(primaryFlights));

    }

}

