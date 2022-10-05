package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Booking_rating;
import com.usa.misiontic.reto3.service.Booking_ratingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking_rating")
public class Booking_ratingController {

    @Autowired
    private Booking_ratingService booking_ratingService;

    @GetMapping("/all")
    public List<Booking_rating> getAll(){
        return booking_ratingService.getAll();
    }

    @PostMapping("/save")
    public Booking_rating save(@RequestBody Booking_rating c){
        return booking_ratingService.save(c);
    }
}
