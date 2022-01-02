package com.example.uber.controller;

import com.example.uber.services.DriverLoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DriverLogin {
    DriverLoginServices driverLoginServices;

    @Autowired
    public DriverLogin(DriverLoginServices driverLoginServices) {
        this.driverLoginServices = driverLoginServices;
    }

    @RequestMapping("/DriverLogin")
    public String Login(@RequestParam Map<String, String> driver) {
        String name = driver.get("driverName");
        String password = driver.get("password");
        return driverLoginServices.LogInDriver(name, password);

    }

    @RequestMapping("/DriverLogOut")
    public String LogOut(@RequestParam Map<String,String> driver){
     String name=driver.get("driverName");
     return driverLoginServices.LogOut(name);

    }


}
