package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@Entity
public class BendingRide {
    static int count;
    @Id
    int id;
    String userName;
    String source;
    String destination;

    public BendingRide(String userName, String source, String destination) {
        count++;
        id=count;
        this.userName = userName;
        this.source = source;
        this.destination = destination;

    }
}
