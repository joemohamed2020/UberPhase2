package com.example.uber.services;

import com.example.uber.models.*;
import com.example.uber.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private UserRepository userRepository;
    private PendingRideRepository pendingRideRepository;
    private DriverRepository driverRepository;
    private RideRepository rideRepository;
    private EventsRepository eventsRepository;

    @Autowired
    public OfferService(UserRepository userRepository, PendingRideRepository pendingRideRepository,DriverRepository driverRepository,RideRepository rideRepository,EventsRepository eventsRepository) {
        this.userRepository = userRepository;
        this.pendingRideRepository = pendingRideRepository;
        this.driverRepository=driverRepository;
        this.rideRepository=rideRepository;
        this.eventsRepository=eventsRepository;
    }

    public String showOffers(String userName) {
        UserData userData = userRepository.getById(userName);
        if (userData.getLogIn()) {
            if (pendingRideRepository.existsById(userName)) {
                PendingRide pendingRide = pendingRideRepository.getById(userName);
                DriverData driverData=driverRepository.getById(pendingRide.getDriverName());
                if (pendingRide.getDriverName() != null) {
                    return "DriverName: " + pendingRide.getDriverName() + "||Offer: " + pendingRide.getOffer() +"||AverageRate: "+driverData.getAVGRate()+ "--->Yes if Accept/No if Refuse";
                } else {
                    return "No Offers Until Now\n";
                }
            } else {
                return "You Didn't Request A Ride!!\n";
            }
        } else {
            return "Please LogIn First :)\n";
        }

    }

    public String Offer(String userName, String driverName, int offer) {
        if (pendingRideRepository.existsById(userName)) {
            PendingRide pendingRide = pendingRideRepository.getById(userName);
            if (driverRepository.existsById(driverName)) {
                DriverData driverData = driverRepository.getById(driverName);
                if (driverData.getLogIn()) {
                    if (pendingRide.getDriverName() == null) {
                        pendingRide.setOffer(offer);
                        pendingRide.setDriverName(driverName);
                        Event event=new Event(pendingRide.getId(),"Captain put a price",System.currentTimeMillis(),userName,driverName,offer);
                        return "Offer Sent";
                    } else {
                        return "There is Already an offer from another Driver sorry";
                    }
                } else {
                    return "You Have To Login First";
                }
            } else {
                return "No Driver With This DriverName!";
            }
        } else {
            return "No Ride With This UserName!";
        }
    }

    public String OfferAction(String userName, String Action) {
        if (userRepository.existsById(userName)) {
            UserData userData = userRepository.getById(userName);
            if (userData.getLogIn()) {
                if (pendingRideRepository.existsById(userName)) {
                    PendingRide pendingRide = pendingRideRepository.getById(userName);
                    if (Action.equalsIgnoreCase("yes")) {
                        Ride ride=new Ride(pendingRide.getId(),pendingRide.getUserName(),pendingRide.getDriverName(),pendingRide.getSource(),pendingRide.getDestination(),pendingRide.getOffer());
                        rideRepository.save(ride);
                        pendingRideRepository.delete(pendingRide);
                        return "Please Wait The Driver Will Arrive Soon";
                    } else {
                        pendingRide.setDriverName(null);
                        pendingRide.setOffer(0);
                        return "Wait For Another Offers";
                    }
                } else {
                    return "You Didn't Request A Ride";
                }
            } else {
                return "Please Login First";
            }

        } else {
            return "There Is No User With This UserName";
        }
    }

}
