package kz.bitlab.projectDto.services;

import kz.bitlab.projectDto.entities.Brand;

import java.util.List;

public interface BrandService {
    Brand addBrand(Brand brand);
    List<Brand> getAllBrands();
    Brand updateBrand(Brand updateBrand);
    void deleteBrand(Long id);
}
