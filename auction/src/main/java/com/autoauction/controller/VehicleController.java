package com.autoauction.controller;

import com.autoauction.entity.Vehicle;
import com.autoauction.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return service.addVehicle(vehicle);
    }

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles(){
        return service.getAllVehicles();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable Long vehicleId){
        return service.getVehicle(vehicleId);
    }

    @PutMapping("/updateVehile/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return service.updateVehicle(id,vehicle);
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable Long vehicleId){
         service.deleteVehicle(vehicleId);
    }

}
