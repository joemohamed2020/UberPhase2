package com.example.uber.models;

import com.example.uber.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.servlet.annotation.HttpConstraint;


@NoArgsConstructor
@Entity
public class BendingRide {
    @Id
    String userName;
    String source;
    String destination;

    public BendingRide(String userName, String source, String destination) {
        this.userName = userName;
        this.source = source;
        this.destination = destination;

    }
}
