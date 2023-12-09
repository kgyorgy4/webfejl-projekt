package com.example.springbackend.service;

import com.example.springbackend.dto.CarDTO;
import com.example.springbackend.dto.CarSaveDTO;
import com.example.springbackend.dto.CarUpdateDTO;
import com.example.springbackend.model.Car;
import com.example.springbackend.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public String addCar(CarSaveDTO carSaveDTO) {
        Car car = new Car(
                carSaveDTO.getRendszam(),carSaveDTO.getSzin(),carSaveDTO.getTulaj_id())
                ;

    carRepo.save(car);
    return car.getRendszam();
    }

    @Override
    public List<CarDTO> getAllCar() {
        List<Car> getCars = carRepo.findAll();
        List<CarDTO> carDTOList= new ArrayList<>();
        for(Car a:getCars){
            CarDTO carDTO = new CarDTO(
                    (long) a.getId(),
                    a.getRendszam(),
                    a.getSzin(),
                    a.getEmployee_id()
            );
    carDTOList.add(carDTO);
        }
        return carDTOList;
    }

    @Override
    public String updateCar(CarUpdateDTO carUpdateDTO) {
        if (carRepo.existsById(carUpdateDTO.getId()))
        {
            Car car = carRepo.getById(carUpdateDTO.getId());
            car.setRendszam(carUpdateDTO.getRendszam());
            car.setSzin(carUpdateDTO.getSzin());
            carRepo.save(car);

        }
        return null;
    }

    @Override
    public boolean deleteCar(long id) {
        if (carRepo.existsById(id))
        {
            carRepo.deleteById(id);
        }
    return true;
    }
}
