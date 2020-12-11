package com.example.lab6122020.model;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Person {
    private String name;
    private String lastName;

    @Builder(builderMethodName = "Personuilder")
    protected Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
