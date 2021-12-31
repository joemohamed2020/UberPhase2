package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
