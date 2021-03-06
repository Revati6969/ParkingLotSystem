package com.bridgelabzs;

import java.util.Map;
import java.util.stream.Collectors;

public class PoliceDepartment {
    public ParkingLotSystem parkingLotSystem;
    public Map<String, Vehicle> vehicles;

    //CONSTRUCTOR
    public PoliceDepartment(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    //METHOD TO GET VEHICLES OF PARTICULAR COLOUR AND RETUNING MAP
    public Map<String, Vehicle> getVehicles(Vehicle.VehicleColour colour) {
        return vehicles = parkingLotSystem.vehicleMap.entrySet().stream()
                .filter(entry -> colour.equals(entry.getValue().vehicleColour))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //METHOD TO GET VEHICLES OF PARTICULAR COLOUR AND MODEL
    public Map<String, Vehicle> getVehiclesWithColorAndModel(Vehicle.VehicleColour vehicleColour, Vehicle.VehicleModel vehicleModel) {
        return vehicles = parkingLotSystem.vehicleMap.entrySet().stream()
                .filter(entry -> vehicleColour.equals(entry.getValue().vehicleColour) &&
                        vehicleModel.equals(entry.getValue().vehicleModel))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
