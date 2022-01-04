package com.example.uber.controller;

import com.example.uber.services.PendingRideServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PendingRide {
    private PendingRideServices pendingRideServices;
    public PendingRide(PendingRideServices pendingRideServices) {
        this.pendingRideServices = pendingRideServices;

    }
    @RequestMapping("/Ride")
    public String  Request(@RequestParam Map<String, String> ride) {
        String userName=ride.get("userName");
        String source=ride.get("source");
        String dest=ride.get("dest");
        String noPassenger=ride.get("noPassengers");
        return pendingRideServices.requestRide(userName,source,dest,Integer.parseInt(noPassenger));

    }

}
