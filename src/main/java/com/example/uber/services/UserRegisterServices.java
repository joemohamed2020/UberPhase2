package com.example.uber.services;

import com.example.uber.models.UserData;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegisterServices {
    UserRepository userRepository;
    @Autowired
    public UserRegisterServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void UserRegister(UserData userData){
        userRepository.save(userData);
    }
}
