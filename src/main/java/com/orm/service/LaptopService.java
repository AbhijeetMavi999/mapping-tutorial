package com.orm.service;

import com.orm.entity.Laptop;

import java.util.List;

public interface LaptopService {

    Laptop saveLaptop(Laptop laptop);

    List<Laptop> getAllLaptops();

    Laptop getLaptopById(Integer laptopId);

    void deleteLaptop(Integer laptopId);
}
