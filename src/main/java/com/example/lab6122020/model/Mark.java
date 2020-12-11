package com.example.lab6122020.model;

import lombok.*;

@ToString
@EqualsAndHashCode
@Builder
public class Mark {

    @Getter
    private final Subject subject;

    @Getter
    @Setter
    private Teacher teacher;

    @Getter
    @Setter
    private int value;
}
