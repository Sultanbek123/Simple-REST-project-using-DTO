package kz.bitlab.projectDto.mapper;

import kz.bitlab.projectDto.entities.Car;
import kz.bitlab.projectDto.entities.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto mapToDto(Car car);
    Car mapToEntity(CarDto carDto);
    List<CarDto> mapToDtoList(List<Car> cars);
}
