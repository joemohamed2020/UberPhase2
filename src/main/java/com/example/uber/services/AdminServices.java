package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.models.UserData;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;

@Service
public class AdminServices {
    private static boolean login = false;
    private static DriverRepository driverRepository;
    private static UserRepository userRepository;

    @Autowired
    public AdminServices(DriverRepository driverRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    public static String Login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("admin")) {
                login = true;
                return "WellCome Admin :)";
            } else {
                return "Wrong Password!";
            }
        } else {
            return "Wrong UserName!!";
        }
    }

    public static String Logout() {
        login = false;
        return "Logout Successfully";
    }

    public static String VerifyDriver(String username) {
        if (login) {
            if (driverRepository.existsById(username)) {
                DriverData driverData = driverRepository.getById(username);
                if (driverData.getStatus() == 0) {
                    driverData.setStatus(1);
                    driverRepository.save(driverData);
                    return "Verify Successfully";
                } else {
                    return "Already Verified!";
                }
            } else {
                return "No Driver Found!!";
            }
        } else {
            return "Please LogIn First!";
        }
    }

    public static String VerifyUser(String userName) {
        if (login) {
            if (userRepository.existsById(userName)) {
                UserData userData = userRepository.getById(userName);
                if (userData.getStatus() == 0) {
                    userData.setStatus(1);
                    userRepository.save(userData);
                    return "Verify Successfully";
                } else {
                    return "Already Verified!";
                }
            } else {
                return "No User Found!!";
            }
        } else {
            return "Please LogIn First!";
        }
    }

    public static String SusUser(String userName) {
        if (login) {
            if (userRepository.existsById(userName)) {
                UserData userData = userRepository.getById(userName);
                if (userData.getStatus() == 1) {
                    userData.setStatus(0);
                    userRepository.save(userData);
                    return "Suspend Successfully";
                } else {
                    return "Already Suspended!";
                }
            } else {
                return "No User Found!!";
            }
        } else {
            return "Please LogIn First!";
        }
    }

    public static String SusDriver(String username) {
        if (login) {
            if (driverRepository.existsById(username)) {
                DriverData driverData = driverRepository.getById(username);
                if (driverData.getStatus() == 1) {
                    driverData.setStatus(0);
                    driverRepository.save(driverData);
                    return "Suspend Successfully";
                } else {
                    return "Already Suspended!";
                }
            } else {
                return "No Driver Found!!";
            }
        } else {
            return "Please LogIn First!";
        }
    }
}
