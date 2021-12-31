package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;

@Service
public class AdminServices {
    static DriverRepository driverRepository;
    UserRepository userRepository;
    @Autowired
    public AdminServices(DriverRepository driverRepository,UserRepository userRepository) {
        this.userRepository=userRepository;
        this.driverRepository = driverRepository;
    }
    public static boolean Login(String username,String password){
        if (username.equals("admin")){
            if (password.equals("admin")){
                System.out.println("WellCome Admin :)");
                return true;
            }
            else {
                System.out.println("Wrong Password!");
            }
        }
        else {
            System.out.println("Wrong UserName!!");
        }
        return false;
    }


    public static void VerifyDriver(String username){
       if(driverRepository.existsById(username)){
           DriverData driverData=driverRepository.getById(username);
           if (driverData.getStatus()==0){
               driverData.setStatus(1);
               driverRepository.save(driverData);
               System.out.println("Verify Successfully");
           }
           else{
               System.out.println("Already Verified!");
           }
       }
       else {
           System.out.println("No Driver Found!!");
       }
    }
}
