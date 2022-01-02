package com.example.uber.services;

import com.example.uber.models.UserData;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServices {
    UserRepository userRepository;
    @Autowired
    public UserLoginServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String LogInUser(String userName,String password){
        if (userRepository.existsById(userName)){
            UserData userData=userRepository.getById(userName);
            if (userData.getPassword().equals(password)){
                if (userData.getStatus()!=0) {
                    userData.setLogIn(true);
                    userRepository.save(userData);
                    return "LogIn Successfully";
                }
                else {
                    return "Your Account Has Been Suspended";
                }
            }
            else{
                return"Wrong Password!!";
            }
        }
        else {
            return"UserName Not Found!!";
        }
    }

    public String LogOut(String userName){
        if (userRepository.existsById(userName)) {
            UserData userData = userRepository.getById(userName);
            userData.setLogIn(false);
            userRepository.save(userData);
            return "Logout successfully";
        }
        else {
            return "No User Exists!";
        }
    }

}
