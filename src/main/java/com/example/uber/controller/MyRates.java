package com.example.uber.controller;

import com.example.uber.services.MyRatesServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyRates {
    MyRatesServices myRates;
    @RequestMapping("/ShowMyRates")
    public String Show(@RequestParam Map<String, String> driver){
        String driverName=driver.get("driverName");
        return myRates.ShowMyRates(driverName);
    }

}
