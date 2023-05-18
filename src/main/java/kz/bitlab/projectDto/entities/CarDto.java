package kz.bitlab.projectDto.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private int year;
    private int month;
    private List<Brand> brands;
}
