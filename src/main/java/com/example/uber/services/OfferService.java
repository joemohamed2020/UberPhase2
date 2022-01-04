package com.example.uber.services;

import com.example.uber.models.*;
import com.example.uber.repository.*;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OfferService {
    private UserRepository userRepository;
    private PendingRideRepository pendingRideRepository;
    private DriverRepository driverRepository;
    private RideRepository rideRepository;
    private EventsRepository eventsRepository;
    private FavAreaRepository favAreaRepository;
    @Autowired
    public OfferService(UserRepository userRepository, PendingRideRepository pendingRideRepository,DriverRepository driverRepository,RideRepository rideRepository,EventsRepository eventsRepository,FavAreaRepository favAreaRepository) {
        this.userRepository = userRepository;
        this.pendingRideRepository = pendingRideRepository;
        this.driverRepository=driverRepository;
        this.rideRepository=rideRepository;
        this.eventsRepository=eventsRepository;
        this.favAreaRepository=favAreaRepository;
    }

    public String showOffers(String userName) {
        UserData userData = userRepository.getById(userName);
        if (userData.getLogIn()) {
            if (pendingRideRepository.existsByUserName(userName)) {
                PendingRide pendingRide = pendingRideRepository.findByUserName(userName);
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
        if (pendingRideRepository.existsByUserName(userName)) {
            PendingRide pendingRide = pendingRideRepository.findByUserName(userName);
            if (driverRepository.existsById(driverName)) {
                DriverData driverData = driverRepository.getById(driverName);
                if (driverData.getLogIn()) {
                    if (pendingRide.getDriverName() == null) {
                        if (driverData.getBusy()==0) {
                            pendingRide.setOffer(offer);
                            pendingRide.setDriverName(driverName);
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date();
                            String frmtdDate = dateFormat.format(date);
                            Event event = new Event(pendingRide.getId(), "Captain put a price", frmtdDate, userName, driverName, offer);
                            eventsRepository.save(event);
                            return "Offer Sent";
                        }
                        else {
                            return "you Already in A Ride";
                        }
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
                if (pendingRideRepository.existsByUserName(userName)) {
                    PendingRide pendingRide = pendingRideRepository.findByUserName(userName);
                    if (Action.equalsIgnoreCase("yes")) {
                        Ride ride=new Ride(pendingRide.getId(),pendingRide.getUserName(),pendingRide.getDriverName(),pendingRide.getSource(),pendingRide.getDestination(),pendingRide.getOffer(),pendingRide.getNoPassengers());
                        rideRepository.save(ride);
                        pendingRideRepository.delete(pendingRide);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = new Date();
                        String frmtdDate = dateFormat.format(date);
                        Event event=new Event(ride.getId(),"User Accept Offer",frmtdDate,ride.getUserName(),ride.getDriverName(),ride.getPrice());
                        event.setAction("Accepted");
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

    public String ShowPendingRides(String driverName){
        if (driverRepository.existsById(driverName)){
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getLogIn()){
                String output="";
                List<FavoriteAreas> list=favAreaRepository.findAllByDriverName(driverName);
                for (int i=0;i<list.size();i++){
                    if (pendingRideRepository.existsBySource(list.get(i).getArea())){
                        List<PendingRide> list1=pendingRideRepository.findAllBySource(list.get(i).getArea());
                        for (int j=0;j<list1.size();j++){
                            System.out.println(output);
                            output+="{UserName: "+list1.get(j).getUserName()+"Source: "+list1.get(j).getSource()+"Destination: "+list1.get(j).getDestination()+"}";
                        }
                    }

                }
                return output;
            }
            else {
                return "LogIn First";
            }
        }
        else {
            return "No driver Exists";
        }
    }


}
