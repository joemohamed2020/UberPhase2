package com.example.uber.controller;

import com.example.uber.services.RideServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Ride {
    private RideServices rideServices;

    @Autowired
    public Ride(RideServices rideServices) {
        this.rideServices = rideServices;
    }
    @RequestMapping("/MyRides")
    public String ShowRide(@RequestParam Map<String, String> userName){
        String name=userName.get("userName");
        return rideServices.ShowMyRides(name);
    }
    @RequestMapping("/Rate")
    public String RateDriver(@RequestParam Map<String, String> User){
        String name=User.get("userName");
        String driverIndex=User.get("id");
        String rate= User.get("rate");
        if (Integer.parseInt(rate)>=1&&Integer.parseInt(rate)<=5) {
            return rideServices.RateDriver(name, Integer.parseInt(driverIndex), Integer.parseInt(rate));
        }
        else{
            return "Number From 1 TO 5";
        }
    }

}
