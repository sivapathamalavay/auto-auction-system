package com.autoauction.repository;

import com.autoauction.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository
            extends JpaRepository<Vehicle, Long>{

}
