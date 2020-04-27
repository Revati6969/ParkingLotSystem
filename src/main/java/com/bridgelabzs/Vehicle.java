package com.bridgelabzs;

public class Vehicle {
    VehicleColour vehicleColour;
    VehicleSize vehicleSize;
    DriverType driverType;
    ParkingDateAndTime parkingDateTime;
    private String parkingDateAndTime;
    private String vehicleId;

    public Vehicle(String vehicleId, DriverType driverType, VehicleSize vehicleSize, VehicleColour vehicleColour) {
        parkingDateTime = new ParkingDateAndTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
        this.vehicleSize = vehicleSize;
        this.vehicleColour =  vehicleColour;
    }

    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public enum DriverType {
        HANDICAP, NORMAL
    }

    public enum VehicleSize {
        LARGE, SMALL
    }

    public enum VehicleColour {
        WHITE, BLUE
    }
}

