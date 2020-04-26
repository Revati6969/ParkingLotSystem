package com.bridgelabzs;

public class Vehicle {
    VehicleSize vehicleSize;
    DriverType driverType;
    ParkingDateAndTime parkingDateTime;
    private String parkingDateAndTime;
    private String vehicleId;

    public Vehicle(String vehicleId, DriverType driverType, VehicleSize vehicleSize) {
        parkingDateTime = new ParkingDateAndTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
        this.vehicleSize = vehicleSize;
    }

    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public enum DriverType {HANDICAP, NORMAL}

    public enum VehicleSize {LARGE, SMALL}
}
