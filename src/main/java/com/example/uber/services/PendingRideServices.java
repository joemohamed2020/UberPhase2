package com.example.uber.services;

import com.example.uber.models.PendingRide;
import com.example.uber.models.DriverData;
import com.example.uber.models.UserData;
import com.example.uber.repository.PendingRideRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PendingRideServices {
    private PendingRideRepository pendingRideRepository;
    private UserRepository userRepository;
    @Autowired
    public PendingRideServices(PendingRideRepository rideRepository,UserRepository userRepository) {
        this.pendingRideRepository = rideRepository;
        this.userRepository = userRepository;
    }

    public String requestRide(String userName, String source, String dest) {

        if (userRepository.existsById(userName)) {
            UserData userData= userRepository.getById(userName);
            if (userData.getLogIn()) {
                DriverData driverData = new DriverData();
                PendingRide ride = new PendingRide(userName, source, dest);
                if (pendingRideRepository.existsById(userData.getUserName())) {
                    return  "You Have Already Request A Ride Please Wait...";
                } else {
                    pendingRideRepository.save(ride);
                    return  "Your Request Send Please Wait For An Offer...";
                }
            }
            else {
                return  "Please LogIn First";
            }
        }
        else {
            return  "There is no User with This Name!";
        }
    }



}

