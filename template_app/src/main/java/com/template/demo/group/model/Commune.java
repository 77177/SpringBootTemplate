package com.template.demo.group.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.template.demo.person.models.Person;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String groupName;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commune")
    List<Person> people = new ArrayList<>();
}
