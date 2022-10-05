package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Admin;
import com.usa.misiontic.reto3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @PostMapping("/save")
    public Admin save(@RequestBody Admin c){
        return adminService.save(c);
    }
}
