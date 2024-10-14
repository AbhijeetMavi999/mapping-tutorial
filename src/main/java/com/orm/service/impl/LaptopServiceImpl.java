package com.orm.service.impl;

import com.orm.entity.Laptop;
import com.orm.repository.LaptopRepository;
import com.orm.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Integer laptopId) {
        return laptopRepository.findById(laptopId).orElse(null);
    }

    @Override
    public void deleteLaptop(Integer laptopId) {
        laptopRepository.deleteById(laptopId);
    }
}
