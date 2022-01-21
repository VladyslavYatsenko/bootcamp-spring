package com.yatsenko.bootcampspring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Cat {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Cat(String name) {
        this.name = name;
    }
}
