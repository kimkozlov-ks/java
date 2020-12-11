package com.brain.firstspringboot.configuration;

import Model.Taxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaxiConfiguration {

    @Bean
    public List<Taxi> taxiList() {
        List<Taxi> taxiList = new ArrayList<>();
        taxiList.add(Taxi.builder()
                .driverName("Driver1")
                .car("car1")
                .carNumber("car number 1")
                .restDay(DayOfWeek.FRIDAY)
                .build());

        taxiList.add(Taxi.builder()
                .driverName("Driver2")
                .car("car2")
                .carNumber("car number 2")
                .restDay(DayOfWeek.SUNDAY)
                .build());

        taxiList.add(Taxi.builder()
                .driverName("Driver3")
                .car("car3")
                .carNumber("car number 3")
                .restDay(DayOfWeek.MONDAY)
                .build());

        return taxiList;
    }
}
