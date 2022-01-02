package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.models.Ride;
import com.example.uber.models.UserData;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.RideRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServices {
    private RideRepository rideRepository;
    private UserRepository userRepository;
    private DriverRepository driverRepository;

    @Autowired
    public RideServices(RideRepository rideRepository,UserRepository userRepository,DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
        this.driverRepository=driverRepository;
    }

    public String ShowMyRides(String userName){
        String output="";
       List<Ride> list= rideRepository.getAllByUserName(userName);
       if (list.size()!=0) {
           for (int i = 0; i < list.size(); i++) {
               output += list.get(i);
           }
           return output;
       }
       else {
           return "No Rides To Show";
       }
    }

    public int AVGRate(String driverName){
        List<Ride> list=rideRepository.getAllByDriverName(driverName);
        int avg=0;
        for (int i=0;i<list.size();i++){
            avg+=list.get(i).getRate();
        }
        avg=avg/list.size();
        return avg;
    }

    public String RateDriver(String userName,int id,int rate){
        if(userRepository.existsById(userName)) {
            UserData userData=userRepository.getById(userName);
            if (userData.getLogIn()) {
                List<Ride> list = rideRepository.getAllByUserName(userName);
                Ride ride = list.get(id);
                if (ride != null) {
                    ride.setRate(rate);
                    rideRepository.save(ride);
                    DriverData driverData=driverRepository.getById(ride.getDriverName());
                    driverData.setAVGRate(AVGRate(ride.getDriverName()));
                    return "Done";
                } else {
                    return "No Rides to Rate!";
                }
            }
            else {
                return "Please Login First";
            }
        }
        else{
            return "No User With This Name!";
        }
    }

}
