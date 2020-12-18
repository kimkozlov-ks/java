package org.example.pojo;


import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Student extends Person {
    private String groupTitle;
    private double averageMark;
    private boolean hasGrant;
    private EducationType educationType;

    @Builder
    public Student(int id, String fio, Date birthday, Gender gender, String groupTitle, double averageMark, boolean hasGrant, EducationType educationType) {
        super(id, fio, birthday, gender);
        this.groupTitle = groupTitle;
        this.averageMark = averageMark;
        this.hasGrant = hasGrant;
        this.educationType = educationType;
    }


}
