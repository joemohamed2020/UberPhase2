package com.example.uber.services;

import com.example.uber.models.BendingRide;
import com.example.uber.models.DriverData;
import com.example.uber.models.UserData;
import com.example.uber.repository.BendingRideRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BendingRideServices {
    BendingRideRepository bendingRideRepository;
    UserRepository userRepository;
    @Autowired
    public BendingRideServices(BendingRideRepository rideRepository,UserRepository userRepository) {
        this.bendingRideRepository = rideRepository;
        this.userRepository = userRepository;
    }
    public void requestRide(String userName, String source, String dest) {

        if (userRepository.existsById(userName)) {
            UserData userData= userRepository.getById(userName);
            DriverData driverData=new DriverData();
            BendingRide ride = new BendingRide(userData, source, dest,driverData);
            if (bendingRideRepository.existsById(userData.getUserName())) {
                System.out.println("You Have Already Request A Ride Please Wait...");
            } else {
                bendingRideRepository.save(ride);
                System.out.println("Your Request Send Please Wait...");
            }
        }
        else {
            System.out.println("There is no User with This Name!");
        }
    }


    }

