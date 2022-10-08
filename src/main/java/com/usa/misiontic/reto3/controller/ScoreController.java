package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Score;
import com.usa.misiontic.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @PostMapping("/save")
    public Score save(@RequestBody Score c){
        return scoreService.save(c);
    }
}
