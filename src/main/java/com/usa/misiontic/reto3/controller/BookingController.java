package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Booking;
import com.usa.misiontic.reto3.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<Booking> getAll(){
        return bookingService.getAll();
    }

    @PostMapping("/save")
    public Booking save(@RequestBody Booking c){
        return bookingService.save(c);
    }
}
