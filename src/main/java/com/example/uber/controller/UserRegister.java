package com.example.uber.controller;

import com.example.uber.models.UserData;
import com.example.uber.services.UserRegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//url
@RestController
public class UserRegister {
    UserRegisterServices userRegisterServices;
    @Autowired
    public UserRegister(UserRegisterServices userRegisterServices) {
        this.userRegisterServices = userRegisterServices;
    }
    @RequestMapping("/UserRegister")
    public void Register(@RequestParam Map<String, String> user) {
        String name=user.get("userName");
        String password=user.get("password");
        String email=user.get("email");
        String phone=user.get("phone");
        UserData userData=new UserData(name,password,email,phone,1);
        userRegisterServices.UserRegister(userData);
    }
}
