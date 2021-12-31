package com.example.uber.controller;

import com.example.uber.services.AdminServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class Admin {
    @RequestMapping("/AdminLogin")
    public void Login(@RequestParam Map<String, String> admin, HttpServletResponse httpServletResponse){
        String name=admin.get("name");
        String password=admin.get("password");
        if (AdminServices.Login(name,password)){
            try{
                httpServletResponse.sendRedirect("/AdminMode");
            }
            catch (IOException e){
                System.out.println("Error!!");
            }
        }
    }
    @RequestMapping("/AdminMode")
    public void VerifyDriver(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        AdminServices.VerifyDriver(name);
    }


}
