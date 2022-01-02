package com.example.uber.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Setter
@Getter
@Entity
public class Ride {
    @Id
    int id;
    private String userName;
    private String driverName;
    private String source;
    private String destination;
    private int price;
    private int rate;

    public Ride(int id,String userName, String driverName, String source, String destination, int price) {
        this.id=id;
        this.userName = userName;
        this.driverName = driverName;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.rate=0;
    }

    public Ride() {

    }
}
