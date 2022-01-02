package com.example.uber.controller;
import com.example.uber.services.UserLoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class UserLogin {
    UserLoginServices userLoginServices;
    @Autowired
    public UserLogin(UserLoginServices userLoginServices) {
        this.userLoginServices = userLoginServices;
    }
    @RequestMapping("/UserLogin")
    public String Login(@RequestParam Map<String, String> user) {
        String name=user.get("userName");
        String password=user.get("password");
        return userLoginServices.LogInUser(name,password);

    }

    @RequestMapping("/UserLogOut")
    public String LogOut(@RequestParam Map<String,String> user){
        String name=user.get("userName");
        return userLoginServices.LogOut(name);
    }
}
