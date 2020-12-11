package com.example.lab6122020.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@ToString
@Builder
public class Markbook {

    @Getter
    private final Student student;

    @Getter
    @Setter
    private Map<Subject, List<Mark>> marksBySubject;
}
