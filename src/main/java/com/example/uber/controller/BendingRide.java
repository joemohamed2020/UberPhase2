package com.example.uber.controller;

import com.example.uber.services.BendingRideServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BendingRide {
    BendingRideServices bendingRideServices;

    public BendingRide(BendingRideServices bendingRideServices) {
        this.bendingRideServices = bendingRideServices;
    }
    @RequestMapping("/Ride")
    public void Request(@RequestParam Map<String, String> ride) {
        String userName=ride.get("userName");
        String source=ride.get("source");
        String dest=ride.get("dest");
        bendingRideServices.requestRide(userName,source,dest);

    }
}
