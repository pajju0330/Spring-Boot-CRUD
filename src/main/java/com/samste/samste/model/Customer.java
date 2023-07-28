package com.samste.samste.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer Id;
    private String name;
    private String email;
    private Integer age;


    public Customer(Integer id, String name, String email, Integer age) {
        Id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Customer(){}

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
