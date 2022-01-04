package com.example.uber.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class TerminatedRide {
    @Id
    int id;
    private String userName;
    private String driverName;
    private String source;
    private String destination;
    private int price;
    private int rate;
    private int noPassengers;

    public TerminatedRide(int id,String userName, String driverName, String source, String destination, int price,int noPassengers) {
        this.id=id;
        this.userName = userName;
        this.driverName = driverName;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.rate=0;
        this.noPassengers=noPassengers;
    }


    public TerminatedRide() {

    }
}
