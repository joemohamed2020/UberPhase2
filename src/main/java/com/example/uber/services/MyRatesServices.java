package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.models.TerminatedRide;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.TerminatedRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRatesServices {
    TerminatedRideRepository terminatedRideRepository;
    DriverRepository driverRepository;

    @Autowired
    public MyRatesServices(TerminatedRideRepository rideRepository, DriverRepository driverRepository) {
        terminatedRideRepository=rideRepository;
        this.driverRepository=driverRepository;
    }

    public String ShowMyRates(String driverName){
        String output="";
        if(driverRepository.existsById(driverName)) {
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getLogIn()) {
                List<TerminatedRide> list = terminatedRideRepository.findAllByDriverName(driverName);
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
