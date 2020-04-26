package com.bridgelabzs;

public class Vehicle {
    DriverType driverType;
    ParkingDateAndTime parkingDateTime;
    private String parkingDateAndTime;
    private String vehicleId;

    public Vehicle(String vehicleId, DriverType driverType) {
        parkingDateTime = new ParkingDateAndTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
    }

    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public enum DriverType {HANDICAP, NORMAL}
}
