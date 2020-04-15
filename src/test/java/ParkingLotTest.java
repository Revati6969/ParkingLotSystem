import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @Before
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    public void givenVehicle_WhenParked_ReturnTrue() throws ParkingLotSystemException {
        parkingLotSystem.ParkingLotSystem(1);
        boolean isParked = parkingLotSystem.parkVehicle(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldNotBeParked() {
        parkingLotSystem.ParkingLotSystem(2);
        try {
            parkingLotSystem.parkVehicle(vehicle);
            parkingLotSystem.parkVehicle(new Object());
        } catch (ParkingLotSystemException e) {
            assertEquals("Parking is full", e.getMessage());
        }
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldUnpark() throws ParkingLotSystemException {
        parkingLotSystem.ParkingLotSystem(1);
        parkingLotSystem.parkVehicle(vehicle);
        Object isUnParked = parkingLotSystem.unParkVehicle(vehicle);
        Assert.assertEquals(vehicle, isUnParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyUnParked_ShouldReturnFalse() throws ParkingLotSystemException {
        parkingLotSystem.ParkingLotSystem(1);
        try {
            parkingLotSystem.parkVehicle(vehicle);
            Object isUnParked = parkingLotSystem.unParkVehicle(new Object());
        } catch (ParkingLotSystemException e) {
            assertEquals("The vehicle is not parked here", e.getMessage());
        }
    }

    @Test
    public void givenParkingLot_WhenParkingLotIsFull_thenShouldNotifyToOwner() throws ParkingLotSystemException {
        Owner owner = new Owner();
        parkingLotSystem.ParkingLotSystem(2, owner);
        Object carOne = new Object();
        Object carTwo = new Object();
        parkingLotSystem.parkVehicle(carOne);
        parkingLotSystem.parkVehicle(carTwo);
        assertEquals("Parking lot is full", owner.getMessage());
    }
}
