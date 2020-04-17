import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private List parkedVehicles;
    private int parkingCapacity;
    private boolean parkingCapacityFull;

    public List<ParkingLotObserver> observers;

    public ParkingLotSystem() {
        this.parkedVehicles = new ArrayList();
        this.observers = new ArrayList();
        for (ParkingLotObserver observer : ParkingLotObserver.values()) {
            this.observers.add(observer);
        }
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
            this.observers.forEach(observer -> observer.isParkingFull = true);
            throw new ParkingLotSystemException("No space available in the parking lot!",
                    ParkingLotSystemException.ExceptionType.PARKING_FULL);
        }
        if (this.isThisCarPresentInTheParkingLot(vehicle)) {
            throw new ParkingLotSystemException("Car already present in parking lot!",
                    ParkingLotSystemException.ExceptionType.CAR_ALREADY_PARKED);
        }
        this.parkedVehicles.add(vehicle);
    }
    public void unParkTheCar(Object vehicle) throws ParkingLotSystemException {
        if (this.isThisCarPresentInTheParkingLot(vehicle)) {
            this.parkedVehicles.remove(vehicle);
            this.observers.forEach(observer -> observer.isParkingFull = false);
            return;
        }
        throw new ParkingLotSystemException("No such car present in parking lot!",
                ParkingLotSystemException.ExceptionType.NO_VEHICLE);
    }
}
