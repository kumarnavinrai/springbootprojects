package com.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trees {
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private int height;
    private long age;

    public Trees(String name, int height, long age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
