package com.autoauction.service;

import com.autoauction.entity.Vehicle;
import com.autoauction.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public Vehicle addVehicle(Vehicle vehicle){
        vehicle.setCurrentBid(vehicle.getStartingPrice());
        return repository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles(){
        return repository.findAll();
    }
}
