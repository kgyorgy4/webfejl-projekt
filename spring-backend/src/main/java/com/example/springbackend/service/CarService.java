package com.example.springbackend.service;

import com.example.springbackend.dto.CarDTO;
import com.example.springbackend.dto.CarSaveDTO;
import com.example.springbackend.dto.CarUpdateDTO;
import com.example.springbackend.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {

    String addCar(CarSaveDTO carSaveDTO);
    List<CarDTO> getAllCar();
    String updateCar(CarUpdateDTO carUpdateDTO);
    boolean deleteCar(long id);
}
