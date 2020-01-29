package com.template.demo.person.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.template.demo.group.model.Commune;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;

    @JsonBackReference
    @ManyToOne
    Commune commune;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
