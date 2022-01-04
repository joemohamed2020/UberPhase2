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
public class RideServices {
    private RideRepository rideRepository;
    private UserRepository userRepository;
    private DriverRepository driverRepository;
    private TerminatedRideRepository terminatedRideRepository;
    private EventsRepository eventsRepository;

    @Autowired
    public RideServices(RideRepository rideRepository, UserRepository userRepository, DriverRepository driverRepository, TerminatedRideRepository terminatedRideRepository,EventsRepository eventsRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.terminatedRideRepository = terminatedRideRepository;
        this.eventsRepository=eventsRepository;
    }

    public String ShowMyRides(String userName) {
        String output = "";
        List<TerminatedRide> list = terminatedRideRepository.findAllByUserName(userName);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                output += list.get(i);
            }
            return output;
        } else {
            return "No Rides To Show";
        }
    }

    public int AVGRate(String driverName) {
        List<TerminatedRide> list = terminatedRideRepository.findAllByDriverName(driverName);
        int avg = 0;
        for (int i = 0; i < list.size(); i++) {
            avg += list.get(i).getRate();
        }
        avg = avg / list.size();
        return avg;
    }

    public String RateDriver(String userName, int id, int rate) {
        if (userRepository.existsById(userName)) {
            UserData userData = userRepository.getById(userName);
            if (userData.getLogIn()) {
                List<TerminatedRide> list = terminatedRideRepository.findAllByUserName(userName);
                TerminatedRide ride = list.get(id);
                if (ride != null) {
                    ride.setRate(rate);
                    terminatedRideRepository.save(ride);
                    DriverData driverData = driverRepository.getById(ride.getDriverName());
                    driverData.setAVGRate(AVGRate(ride.getDriverName()));
                    return "Done";
                } else {
                    return "No Rides to Rate!";
                }
            } else {
                return "Please Login First";
            }
        } else {
            return "No User With This Name!";
        }
    }

    public String TerminateRide(String driverName) {
        if (driverRepository.existsById(driverName)) {
            DriverData driverData = driverRepository.getById(driverName);
            if (driverData.getLogIn()) {
                if (rideRepository.existsByDriverName(driverName)) {
                    Ride ride = rideRepository.getAllByDriverName(driverName);
                    TerminatedRide terminatedRide = new TerminatedRide(ride.getId(), ride.getUserName(), ride.getDriverName(), ride.getSource(), ride.getDestination(), ride.getPrice(), ride.getNoPassengers());
                    terminatedRideRepository.save(terminatedRide);
                    rideRepository.delete(ride);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String frmtdDate = dateFormat.format(date);
                    Event event=new Event(ride.getId(),"RideEnd",frmtdDate,ride.getUserName(),ride.getDriverName(),ride.getPrice());
                    eventsRepository.save(event);
                    return "Done";
                } else {
                    return "You Are Not In A ride";
                }
            } else {
                return "Login First";
            }
        } else {
            return "No Driver With This Name";
        }
    }

    public String Arrived(String driverName) {
        if (driverRepository.existsById(driverName)) {
            DriverData driverData = driverRepository.getById(driverName);
            if (driverData.getLogIn()) {
                if (rideRepository.existsByDriverName(driverName)) {
                    Ride ride = rideRepository.getAllByDriverName(driverName);
                    ride.setDriverStatus("Arrived");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String frmtdDate = dateFormat.format(date);
                    Event event =new Event(ride.getId(),"DriverArrived", frmtdDate,ride.getUserName(),ride.getDriverName(),ride.getPrice());
                    event.setDriverStatus("Arrived");
                    eventsRepository.save(event);
                    rideRepository.save(ride);
                    return "Done";
                } else {
                    return "You Are Not In A ride";
                }
            } else {
                return "Login First";
            }
        } else {
            return "No Driver With This Name";
        }
    }
}
