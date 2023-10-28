package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String address;

    public CustomerEntity(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public CustomerEntity() {
    }

    public CustomerEntity(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
