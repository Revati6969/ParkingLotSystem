package parkinglotessetials;

import exceptions.ParkingLotSystemException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLotSystem {

    private final List parkedVehicles;
    private List<ParkingTimeSlot> vehicles;
    private SlotAllotment slotManager ;
    private int parkingCapacity;
    private boolean parkingCapacityFull;
    private int parkingLotCapacity;

    public ParkingLotSystem(int parkingCapacity) {
        this.parkedVehicles = new ArrayList(parkingCapacity);
        this.slotManager = new SlotAllotment(parkingCapacity);
    }

    public void setParkingLotCapacity(int capacity) {
        this.parkingCapacity = capacity;
    }

    public boolean isThisCarPresentInTheParkingLot(Object vehicle) {
        if (this.parkedVehicles.contains(vehicle)) {
            return true;
        }
        return false;
    }

    public void parkTheCar(Object vehicle) throws ParkingLotSystemException {
        if (this.parkedVehicles.size() == this.parkingCapacity) {
            this.parkingCapacityFull = true;
            throw new ParkingLotSystemException("No space available in the parking lot!",
                    ParkingLotSystemException.ExceptionType.PARKING_FULL);
        }
        if (this.isThisCarPresentInTheParkingLot(vehicle)) {
            throw new ParkingLotSystemException("Car already present in parking lot!",
                    ParkingLotSystemException.ExceptionType.CAR_ALREADY_PARKED);
        }
        int slot = this.getSlot();
        this.parkedVehicles.add(slot,vehicle);
        this.slotManager.parkUpdate(vehicle,slot);
    }

    private int getSlot() throws ParkingLotSystemException {
        return slotManager.getAvailableParkingSlot()-1;
    }

    public void unParkTheCar(Object vehicle) throws ParkingLotSystemException {
        if (!this.isThisCarPresentInTheParkingLot(vehicle)) {
            throw new ParkingLotSystemException("No such car present in parking lot!",
                    ParkingLotSystemException.ExceptionType.NO_VEHICLE);
        }
        this.parkedVehicles.remove(vehicle);
        this.slotManager.unParkUpdate(vehicle);
        return;
    }

    public int initializeParkingLot() {
        IntStream.range(0, this.parkingLotCapacity).forEach(slots -> vehicles.add(null));
        return vehicles.size();
    }

    public boolean setTime(Object vehicle) {
        ParkingTimeSlot parkingTimeSlot = new ParkingTimeSlot(vehicle);
        for (int i = 0; i < this.vehicles.size(); i++) {
            if (this.vehicles.get(i).time != null && this.vehicles.contains(parkingTimeSlot))
                return true;
        }
        return false;
    }
}
