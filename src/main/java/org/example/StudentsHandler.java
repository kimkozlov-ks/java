package org.example;

import com.google.common.collect.HashMultimap;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.EducationType;
import org.example.pojo.Gender;
import org.example.pojo.Student;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

@Slf4j
public class StudentsHandler {

    @Getter
    private final HashMultimap<String, Student> groupsWithStudents = HashMultimap.create();

    public void read() {
        BuilderFunc<Student> builderFunc = new BuilderFunc<Student>() {
            @Override
            public Student build(String[] rowValues) {
                Student student = Student.builder()
                        .id(Integer.parseInt(rowValues[0]))
                        .fio(rowValues[1])
                        .birthday(new SimpleDateFormat("yyyy.MM.dd").parse(rowValues[2], new ParsePosition(0)))
                        .gender((Gender.valueOf(rowValues[3])))
                        .groupTitle(rowValues[4])
                        .averageMark(Double.parseDouble(rowValues[5]))
                        .educationType(EducationType.valueOf(rowValues[6]))
                        .hasGrant(Boolean.parseBoolean(rowValues[7]))
                        .build();

                groupsWithStudents.put(student.getGroupTitle(), student);

                log.info(student.toString());
                return student;
            }
        };

        Reader<Student> reader = new csvReader<>();
        reader.read("test.txt", builderFunc);
    }
}
