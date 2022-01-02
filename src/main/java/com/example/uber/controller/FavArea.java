package com.example.uber.controller;

import com.example.uber.services.FavAreaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FavArea {
   private FavAreaServices favAreaServices;
   @Autowired
   public FavArea(FavAreaServices favAreaServices) {
      this.favAreaServices = favAreaServices;
   }

   @RequestMapping("/AddFav")
   public String AddFav(@RequestParam Map<String, String> driver){
      String name = driver.get("driverName");
      String location = driver.get("location");
      return favAreaServices.AddFavArea(name,location);
   }
   @RequestMapping("/ShowFav")
   public String ShowFav(@RequestParam Map<String, String> driver){
      String name = driver.get("driverName");
      return favAreaServices.MyFavArea(name);
   }
}
