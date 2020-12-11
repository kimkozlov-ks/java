package com.brain.firstspringboot.repository;

import Model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TaxiRepository {

    @Autowired
    List<Taxi> taxiList;

    public Taxi getFreeTaxi(){
        return taxiList.stream()
                .filter(taxi -> taxi.getRestDay() != LocalDate.now().getDayOfWeek())
                .findFirst().get();
    }
}
