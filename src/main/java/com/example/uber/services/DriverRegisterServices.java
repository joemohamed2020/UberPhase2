package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverRegisterServices {
    DriverRepository driverRepository;
    @Autowired
    public DriverRegisterServices(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public void DriverRegister(DriverData driverData){
        if (driverRepository.existsById(driverData.getUserName())) {
            System.out.println("this Driver is already exists!");
        }
        else {
            driverRepository.save(driverData);
            System.out.println("Registered Successfully");
        }
    }
}
