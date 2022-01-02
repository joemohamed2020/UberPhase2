package com.example.uber.services;

import com.example.uber.models.DriverData;
import com.example.uber.models.FavoriteAreas;
import com.example.uber.repository.DriverRepository;
import com.example.uber.repository.FavAreaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter

@Service
public class FavAreaServices {
    private FavAreaRepository favAreaRepository;
    private DriverRepository driverRepository;

    @Autowired
    public FavAreaServices(FavAreaRepository favAreaRepository, DriverRepository driverRepository) {
        this.favAreaRepository = favAreaRepository;
        this.driverRepository = driverRepository;
    }
    public String AddFavArea(String driverName, String location){
        boolean check=false;
        if (driverRepository.existsById(driverName)){
            DriverData driverData=driverRepository.getById(driverName);
            List<FavoriteAreas> list=favAreaRepository.findAllByDriverName(driverName);
            for (int i=0;i<list.size();i++){
                if (list.get(i).getArea()==location){
                    check=true;
                    break;
                }
            }
            if (driverData.getLogIn()){
                if (!check) {
                    FavoriteAreas favArea = new FavoriteAreas(driverName, location);
                    favAreaRepository.save(favArea);
                    return "Favorite Area Added";
                }
                else {
                    return "This Location Is Already In your Favourite Area";
                }
            }
            else {
                return "Login First";
            }
        }
        else {
            return "No Driver Exists!";
        }
    }
    public String MyFavArea(String driverName){
        if (driverRepository.existsById(driverName)){
            DriverData driverData=driverRepository.getById(driverName);
            if (driverData.getLogIn()){
                String output;
                List<FavoriteAreas> list= favAreaRepository.findAllByDriverName(driverName);
                if (list.size()!=0) {
                    output = "Your Favorite Areas Are: [" + list.get(0).getArea();
                    for (int i = 1; i < list.size(); i++) {
                        output += ",";
                        output += list.get(i).getArea();
                    }
                    output += "]";
                    return output;
                }
                else {
                    return "No Favorite Areas Found";
                }
            }
            else {
                return "Please LogIn First!";
            }
        }
        else {
            return "Driver Not Exists!";
        }
    }

}
