package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PendingRide {
    @Id
    private String userName;
    private String source;
    private String destination;
    private String driverName;
    private int offer;

    public PendingRide(String userName, String source, String destination) {
        this.userName = userName;
        this.source = source;
        this.destination = destination;
    }
}
