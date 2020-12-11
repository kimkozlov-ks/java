package com.brain.firstspringboot.service;

import Model.Taxi;
import com.brain.firstspringboot.configuration.TaxiConfiguration;
import com.brain.firstspringboot.repository.TaxiRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxiCaller {

    private TaxiRepository taxiRepository;

    public TaxiCaller(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public void call(String caller){
        Taxi freeTaxi = taxiRepository.getFreeTaxi();
        System.out.println("Call taxi for " + caller);
        System.out.println("Car :" + freeTaxi);
    }
}
