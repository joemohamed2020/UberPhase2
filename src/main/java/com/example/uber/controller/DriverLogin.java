package com.example.uber.controller;

import com.example.uber.services.DriverLoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class DriverLogin {
    DriverLoginServices driverLoginServices;

    @Autowired
    public DriverLogin(DriverLoginServices driverLoginServices) {
        this.driverLoginServices = driverLoginServices;
    }

    @RequestMapping("/DriverLogin")
    public void  Login(@RequestParam Map<String, String> driver,HttpServletResponse httpServletResponse) {
        String name = driver.get("driverName");
        String password = driver.get("password");
        if(driverLoginServices.LogInDriver(name, password)){
            try {
                httpServletResponse.sendRedirect("/" + name);
            }
            catch (IOException e){
                System.out.println("Error!");
            }
        }

    }


}
