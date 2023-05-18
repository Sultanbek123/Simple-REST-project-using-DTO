package kz.bitlab.projectDto.services;

import kz.bitlab.projectDto.entities.Car;
import kz.bitlab.projectDto.entities.CarDto;

import java.util.List;

public interface CarService {
    CarDto addCar(CarDto carDto);
    List<CarDto> getAllCars();
    CarDto updateCar(CarDto updateCarDto);
    void deleteCar(Long id);
    CarDto getCar(Long id);
}
