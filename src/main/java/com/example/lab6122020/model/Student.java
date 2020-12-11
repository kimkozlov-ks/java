package com.example.lab6122020.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
public class Student extends Person {

    @Builder(builderMethodName = "StudentBuilder")
    protected Student(String name, String lastName) {
        super(name, lastName);
    }
}
