package com.example.uber.controller;

import com.example.uber.services.AdminServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class Admin {
    @RequestMapping("/AdminLogin")
    public String  Login(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        String password=admin.get("password");
        return AdminServices.Login(name,password);
    }

    @RequestMapping("/AdminMode")
    public String VerifyDriver(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        return AdminServices.VerifyDriver(name);
    }

    @RequestMapping("/AdminMode2")
    public String SusDriver(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        return AdminServices.SusDriver(name);
    }

    @RequestMapping("/AdminMode3")
    public String VerifyUser(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        return AdminServices.VerifyUser(name);
    }

    @RequestMapping("/AdminMode4")
    public String SusUser(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        return AdminServices.SusUser(name);
    }

    @RequestMapping("/AdminLogout")
    public String Logout(@RequestParam Map<String, String> admin){
        String name=admin.get("name");
        return AdminServices.Logout();

    }


}
