package com.brain.firstspringboot.component;

import com.brain.firstspringboot.service.TaxiCaller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    @Value("${user.properties.person.name}")
    private String name;

    @Value("${user.properties.person.phone}")
    private String phone;

    @Autowired
    private TaxiCaller taxiCaller;
    public void goTaxi(){
        taxiCaller.call(name);
    }
}
