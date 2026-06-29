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

    public Vehicle getVehicle(Long vehicleId){ return repository.getReferenceById(vehicleId);
    }
    public Vehicle updateVehicle(Long vehicleId,Vehicle vehicle){
        Vehicle vehicleExists = repository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicleExists.setBrand(vehicle.getBrand());
        vehicleExists.setModel(vehicle.getModel());
        vehicleExists.setYear(vehicle.getYear());
        vehicleExists.setStartingPrice(vehicle.getStartingPrice());
        return repository.save(vehicleExists);}

    public void deleteVehicle(Long vehicleId){ repository.deleteById(vehicleId);}
}
