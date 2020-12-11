package com.example.lab6122020.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@EqualsAndHashCode
@ToString
@Value
public class Subject {
    String title;

    @Builder
    protected Subject(String title) {
        this.title = title;
    }
}
