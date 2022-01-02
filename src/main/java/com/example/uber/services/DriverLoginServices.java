package com.example.uber.services;
import com.example.uber.models.DriverData;
import com.example.uber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverLoginServices {
    private DriverRepository driverRepository;
    @Autowired
    public DriverLoginServices(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public String LogInDriver(String driverName,String password){
        if (driverRepository.existsById(driverName)){
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getPassword().equals(password)){
                if (driverData.getStatus()==0){
                    return  "Your Account Suspended";
                }
                driverData.setLogIn(true);
                driverRepository.save(driverData);
                return "LogIn Successfully";
            }
            else{
                return "Wrong Password!!";

            }
        }
        else {
            return"DriverName Not Found!!";
        }
    }
    public String LogOut(String driverName){
        if (driverRepository.existsById(driverName)) {
            DriverData driverData = driverRepository.getById(driverName);
            driverData.setLogIn(false);
            driverRepository.save(driverData);
            return "Logout Successfully";
        }
        else{
            return "No User Exists!";
        }
    }

}
