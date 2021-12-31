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
    public void Login(@RequestParam Map<String, String> user, HttpServletResponse httpServletResponse) {
        String name=user.get("userName");
        String password=user.get("password");
        if (userLoginServices.LogInUser(name,password)){
            try {
                httpServletResponse.sendRedirect("/" + name);
            }
            catch (IOException e)
            {
                System.out.println("Error!!");
            }
        }

    }
}
