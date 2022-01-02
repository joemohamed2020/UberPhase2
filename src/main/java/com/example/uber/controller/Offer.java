package com.example.uber.controller;

import com.example.uber.services.OfferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class Offer {
    private OfferService offerService;

    public Offer(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping("/ShowOffer")
    public String showOffer(@RequestParam Map<String,String> user){
        String userName=user.get("userName");
        return offerService.showOffers(userName);
    }
    @RequestMapping("/DriverOffer")
    public String offer(@RequestParam Map<String,String> offer){
        String userName=offer.get("userName");
        String driverName=offer.get("driverName");
        String off=offer.get("offer");
        return offerService.Offer(userName,driverName, Integer.parseInt(off));
    }
    @RequestMapping("/ShowOffer")
    public String OfferAction(@RequestParam Map<String,String> user){
        String userName=user.get("userName");
        String action=user.get("action");
        return offerService.OfferAction(userName,action);
    }

}
