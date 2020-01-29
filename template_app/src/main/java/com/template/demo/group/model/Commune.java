package com.template.demo.group.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
