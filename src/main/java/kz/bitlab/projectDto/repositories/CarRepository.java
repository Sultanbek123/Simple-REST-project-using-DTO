package kz.bitlab.projectDto.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.projectDto.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findAllById(Long id);
}
