package org.example.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Person extends Entity {
    private String fio;
    private Date birthday;
    private Gender gender;

    public Person(int id) {
        super(id);
    }

    public Person(int id, String fio, Date birthday, Gender gender) {
        super(id);
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
    }
}
