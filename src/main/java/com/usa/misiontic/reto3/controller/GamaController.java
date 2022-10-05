package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Gama;
import com.usa.misiontic.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gama")
public class GamaController {

    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll(){
        return gamaService.getAll();
    }

    @PostMapping("/save")
    public Gama save(@RequestBody Gama c){
        return gamaService.save(c);
    }
}
