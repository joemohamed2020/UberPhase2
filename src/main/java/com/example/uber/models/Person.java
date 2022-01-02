package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public class Person {
    @Id
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private Boolean LogIn;
    private int status;


}
