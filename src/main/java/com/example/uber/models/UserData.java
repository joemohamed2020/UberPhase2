package com.example.uber.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class UserData extends Person{
    public UserData() {
        super();
    }

    public UserData(String name, String password, String email, String phone) {
        super(name,password,email,phone);
    }
}
