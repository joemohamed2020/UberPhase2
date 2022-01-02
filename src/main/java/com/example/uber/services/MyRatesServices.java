package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.models.Ride;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRatesServices {
    RideRepository rideRepository;
    DriverRepository driverRepository;

    @Autowired
    public MyRatesServices(RideRepository rideRepository,DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository=driverRepository;
    }

    public String ShowMyRates(String driverName){
        String output="";
        if(driverRepository.existsById(driverName)) {
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getLogIn()) {
                List<Ride> list = rideRepository.getAllByDriverName(driverName);
                if (list.size() != 0) {
                    for(int i=0;i<list.size();i++){
                        output+="{UserName: "+list.get(i).getUserName()+"||Rate: "+list.get(i).getRate()+"}";
                    }
                    return output;
                }
                else {
                    return "No Rates Until Now!";
                }
            }
            else {
                return "Login First";
            }
        }
        else {
            return "Driver Not Exists";
        }
    }
}
