package com.example.springbackend.controller;

import com.example.springbackend.dto.CarDTO;
import com.example.springbackend.dto.CarSaveDTO;
import com.example.springbackend.dto.CarUpdateDTO;
import com.example.springbackend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String addCar(@RequestBody CarSaveDTO carSaveDTO)
    {
        String id = carService.addCar(carSaveDTO);
        return id;
    }

    @GetMapping("/cars")
    public List<CarDTO> getAllCar()
    {
        List<CarDTO>allCars = carService.getAllCar();
        return allCars;
    }
    @PutMapping("/update")
    public String updateCar(@RequestBody CarUpdateDTO carUpdateDTO)
    {
        String id = carService.updateCar(carUpdateDTO);
        return id;

    }
    @DeleteMapping("delete/{id}")
    public String deleteCar(@PathVariable(value = "id") long id)
    {
        boolean deleteCar = carService.deleteCar(id);
        return "deleted";

    }


}
