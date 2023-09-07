package com.demo.model;

import lombok.Data;

import javax.persistence.*;

//@Data
//@Entity
//@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;
}
