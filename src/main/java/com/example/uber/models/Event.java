package com.example.uber.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalTime;

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
    private String eventTime;
    private String userName;
    private String driverName;
    private int price;
    private String Action="null";
    private String driverStatus="null";

    public Event(int id,String eventName, String eventTime, String userName, String driverName, int price) {
        this.rideId=id;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.userName = userName;
        this.driverName = driverName;
        this.price = price;
    }
}
