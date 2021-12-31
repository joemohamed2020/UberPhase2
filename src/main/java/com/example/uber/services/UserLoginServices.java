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

    public boolean LogInUser(String userName,String password){
        if (userRepository.existsById(userName)){
            UserData userData=userRepository.getById(userName);
            if (userData.getPassword().equals(password)){
                System.out.println("LogIn Successfully");
                return true;
            }
            else{
                System.out.println("Wrong Password!!");
            }
        }
        else {
            System.out.println("UserName Not Found!!");
        }
        return false;
    }

}
