package kz.bitlab.projectDto.services.impl;

import kz.bitlab.projectDto.entities.Brand;
import kz.bitlab.projectDto.repositories.BrandRepository;
import kz.bitlab.projectDto.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Brand updateBrand) {
        Brand brand = brandRepository.findAllById(updateBrand.getId());
        brand.setName(updateBrand.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
