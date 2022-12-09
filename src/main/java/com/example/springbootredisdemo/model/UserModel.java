package com.example.springbootredisdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private long id;
    private int age;
    private String firstName;
    private String lastName;
    private String email;
}
