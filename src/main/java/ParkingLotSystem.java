import exceptions.ParkingLotSystemException;
import parkinglotessetials.SlotAllotment;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private final List parkedVehicles;
    private SlotAllotment slotManager ;
    private int parkingCapacity;
    private boolean parkingCapacityFull;

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
        return slotManager.getNearestParkingSlot()-1;
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
}
