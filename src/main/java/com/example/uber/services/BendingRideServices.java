package com.example.uber.services;

import com.example.uber.models.BendingRide;
import com.example.uber.repository.BendingRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BendingRideServices {
    BendingRideRepository bendingRideRepository;
    @Autowired
    public BendingRideServices(BendingRideRepository rideRepository) {
        this.bendingRideRepository = rideRepository;
    }
    public void requestRide(String userName,String source,String dest){
        BendingRide ride=new BendingRide(userName,source,dest);
            if (bendingRideRepository.existsById(userName)){
                System.out.println("You Have Already Request A Ride Please Wait...");
            }
            else {
                bendingRideRepository.save(ride);
                System.out.println("Your Request Send Please Wait...");
            }
        }


    }

