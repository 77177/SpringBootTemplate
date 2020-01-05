package com.template.demo.person.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
