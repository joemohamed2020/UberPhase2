package com.example.uber.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int rideId;
    private String eventName;
    private long eventTime;
    private String userName;
    private String driverName;
    private int price;
    private String Action="null";

    public Event(int id,String eventName, long eventTime, String userName, String driverName, int price) {
        this.rideId=id;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.userName = userName;
        this.driverName = driverName;
        this.price = price;
    }
}
