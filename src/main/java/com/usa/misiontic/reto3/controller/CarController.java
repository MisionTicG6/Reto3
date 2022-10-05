package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Car;
import com.usa.misiontic.reto3.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @PostMapping("/save")
    public Car save(@RequestBody Car c){
        return carService.save(c);
    }
}
