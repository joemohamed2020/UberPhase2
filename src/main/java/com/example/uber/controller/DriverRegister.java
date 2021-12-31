package com.example.uber.controller;

import com.example.uber.models.DriverData;
import com.example.uber.services.DriverRegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DriverRegister {
    DriverRegisterServices driverRegisterServices;
    @Autowired
    public DriverRegister(DriverRegisterServices driverRegisterServices) {
        this.driverRegisterServices = driverRegisterServices;
    }
    @RequestMapping("/DriverRegister")
    public void Register(@RequestParam Map<String, String> Driver) {
        String name=Driver.get("driverName");
        String password=Driver.get("password");
        String email=Driver.get("email");
        String phone=Driver.get("phone");
        String licence=Driver.get("licence");
        String nationalId=Driver.get("nationalId");
        DriverData driverData=new DriverData(name,password,email,phone,licence,nationalId,0);
        driverRegisterServices.DriverRegister(driverData);
    }

}
