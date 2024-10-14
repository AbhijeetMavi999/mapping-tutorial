package com.orm.controller;

import com.orm.entity.Laptop;
import com.orm.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public Laptop saveLaptop(@RequestBody Laptop laptop) {
        return laptopService.saveLaptop(laptop);
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable Integer id) {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable Integer id) {
        laptopService.deleteLaptop(id);
    }
}
