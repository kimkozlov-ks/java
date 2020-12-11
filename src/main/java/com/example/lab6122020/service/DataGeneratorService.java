package com.example.lab6122020.service;


import com.example.lab6122020.model.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DataGeneratorService {

    @Bean
    @Qualifier(value = "Student1Markbook")
    public Markbook generateMarkbook() {
        Student student = Student.StudentBuilder()
                .name("Student name")
                .lastName("Student lastname")
                .build();

        Teacher teacher = Teacher.TeacherBuilder()
                .name("Teacher name")
                .lastName("Teacher lastname")
                .build();

        Subject subject = Subject.builder()
                .title("Math")
                .build();

        List<Mark> marks = new ArrayList<>();
        marks.add(Mark.builder()
                .teacher(teacher)
                .subject(subject)
                .value(10)
                .build());
        marks.add(Mark.builder()
                .teacher(teacher)
                .subject(subject)
                .value(12)
                .build());
        marks.add(Mark.builder()
                .teacher(teacher)
                .subject(subject)
                .value(5)
                .build());
        marks.add(Mark.builder()
                .teacher(teacher)
                .subject(subject)
                .value(2)
                .build());

        Map<Subject, List<Mark>> marksBySubject = new HashMap<>();
        marksBySubject.put(subject, marks);

        Markbook markbook = Markbook.builder()
                .student(student)
                .marksBySubject(marksBySubject)
                .build();

        return markbook;
    }
}
