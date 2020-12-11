package com.example.lab6122020.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@ToString
public class Teacher extends Person {

    @Builder(builderMethodName = "TeacherBuilder")
    protected Teacher(String name, String lastName) {
        super(name, lastName);
    }
}
