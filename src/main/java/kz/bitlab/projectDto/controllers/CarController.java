package kz.bitlab.projectDto.controllers;

import kz.bitlab.projectDto.entities.CarDto;
import kz.bitlab.projectDto.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public List<CarDto> getAllCars(){
        return carService.getAllCars();
    }
    @PostMapping
    public CarDto addCar(@RequestBody CarDto carDto){
        return carService.addCar(carDto);
    }
    @PutMapping
    public CarDto updateCar(@RequestBody CarDto updateCarDto){
        return carService.updateCar(updateCarDto);
    }
    @DeleteMapping(value="/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
    @GetMapping(value="/{id}")
    public CarDto getCar(@PathVariable("id") Long id){
        return carService.getCar(id);
    }
}
