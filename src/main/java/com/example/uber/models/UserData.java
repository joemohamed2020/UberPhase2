package com.example.uber.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class UserData extends Person implements Serializable {
    public UserData() {
        super();
    }

    public UserData(String name, String password, String email, String phone,int status) {
        super(name,password,email,phone,false,status);
    }
}
