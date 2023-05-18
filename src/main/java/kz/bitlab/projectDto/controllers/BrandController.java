package kz.bitlab.projectDto.controllers;

import kz.bitlab.projectDto.entities.Brand;
import kz.bitlab.projectDto.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }
    @PostMapping
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }
    @PutMapping
    public Brand updateBrand(@RequestBody Brand updatedBrand){
        return brandService.updateBrand(updatedBrand);
    }
    @DeleteMapping(value="/{id}")
    public void deleteBrand(@PathVariable("id")Long id){
        brandService.deleteBrand(id);
    }
}
