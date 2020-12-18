package org.example.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
@Getter
public class Entity {
    int id;
    Date dateCreated = new Date();

    public Entity(int id) {
        this.id = id;
    }
}
