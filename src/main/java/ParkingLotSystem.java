import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    List<Object> vehiclesList = new ArrayList<>();
    private Object vehicle;
    private int capacity;
    private int spaceAvailable;
    private Owner owner;
    private AirportSecurity airportSecurity;

    public void ParkingLotSystem(int capacity) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
    }

    public void ParkingLotSystem(int capacity, Owner owner) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
        this.owner = owner;
    }

    public boolean parkVehicle(Object vehicle) throws ParkingLotSystemException {
        if (spaceAvailable > 0) {
            if (this.vehicle != null) {
                throw new ParkingLotSystemException("Parking lot is full", ParkingLotSystemException.ExceptionType.PARKING_FULL);
            }
            vehiclesList.add(vehicle);
            if (vehiclesList.size() == capacity) {
                if (owner != null) {
                    owner.setMessage("Parking lot is full");
                } else
                    airportSecurity.setMessage("Parking lot is full");
            }
            spaceAvailable--;
            return true;
        }
        throw new ParkingLotSystemException("Parking lot is full", ParkingLotSystemException.ExceptionType.PARKING_FULL);
    }

    public Object unParkVehicle(Object vehicle) throws ParkingLotSystemException {
        if (vehiclesList.contains(vehicle)) {
            return vehiclesList.remove(vehiclesList.indexOf(vehicle));
        }
        throw new ParkingLotSystemException("The vehicle is not parked here", ParkingLotSystemException.ExceptionType.NO_VEHICLE);
    }
}
