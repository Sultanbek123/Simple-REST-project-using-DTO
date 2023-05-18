package kz.bitlab.projectDto.services.impl;

import kz.bitlab.projectDto.entities.Car;
import kz.bitlab.projectDto.entities.CarDto;
import kz.bitlab.projectDto.mapper.CarMapper;
import kz.bitlab.projectDto.repositories.CarRepository;
import kz.bitlab.projectDto.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;
    @Override
    public CarDto addCar(CarDto carDto) {
        String uuidCode = UUID.randomUUID().toString();
        ArrayList<Integer> dashPositions = new ArrayList<>();
        for(int i = 0; i < uuidCode.length(); i++){
            if(uuidCode.charAt(i) == '-'){
                dashPositions.add(i);
            }
        }
        String preVinCode = "";
        for(int i = dashPositions.get(1);i < dashPositions.get(3); i++){
            preVinCode = preVinCode + uuidCode.charAt(i);
        }
        String prefixVinCode = carDto.getYear() + "-" + carDto.getMonth();
        String vinCode = prefixVinCode + preVinCode;
        Car car = Car.builder()
                .model(carDto.getModel())
                .year(carDto.getYear())
                .month(carDto.getMonth())
                .vin(vinCode)
                .brands(carDto.getBrands())
                .build();


        return carMapper.mapToDto(carRepository.save(car));
    }

    @Override
    public List<CarDto> getAllCars() {
        return carMapper.mapToDtoList(carRepository.findAll());
    }

    @Override
    public CarDto updateCar(CarDto updateCarDto) {
        Car car = carRepository.findAllById(updateCarDto.getId());
        car.setModel(updateCarDto.getModel());
        car.setYear(updateCarDto.getYear());
        car.setMonth(updateCarDto.getMonth());
        return carMapper.mapToDto(carRepository.save(car));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto getCar(Long id) {
        return carMapper.mapToDto(carRepository.findAllById(id));
    }
}
