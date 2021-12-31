package com.example.uber.services;
import com.example.uber.models.DriverData;
import com.example.uber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverLoginServices {
    DriverRepository driverRepository;
    @Autowired
    public DriverLoginServices(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public boolean LogInDriver(String driverName,String password){
        if (driverRepository.existsById(driverName)){
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getPassword().equals(password)){
                System.out.println("LogIn Successfully");
                return true;
            }
            else{
                System.out.println("Wrong Password!!");

            }
        }
        else {
            System.out.println("DriverName Not Found!!");
        }
    return false;
    }

}
