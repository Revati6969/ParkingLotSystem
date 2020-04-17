import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @Before
    public void setUp()  {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
        parkingLotSystem.setParkingLotCapacity(2);

    }

    @Test
    public void givenVehicle_WhenParked_ReturnTrue() throws ParkingLotSystemException {
        parkingLotSystem.parkTheCar(vehicle);
        boolean isParked = parkingLotSystem.isThisCarPresentInTheParkingLot(vehicle);
        Assert.assertTrue(isParked);
    }

    /*@Test
    public void givenVehicle_WhenAlreadyParked_ShouldNotBeParked() {
        parkingLotSystem.ParkingLotSystem(2);
        try {
            parkingLotSystem.parkVehicle(vehicle);
            parkingLotSystem.parkVehicle(new Object());
        } catch (ParkingLotSystemException e) {
            assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
        }
    }*/

    @Test
    public void givenVehicle_WhenUnParked_ShouldUnpark() {
        try {
            parkingLotSystem.parkTheCar(vehicle);
            parkingLotSystem.unParkTheCar(vehicle);
            boolean isUnParked = parkingLotSystem.isThisCarPresentInTheParkingLot(vehicle);
            Assert.assertFalse(isUnParked);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_WhenAlreadyUnParked_ShouldReturnFalse(){
        try {
            parkingLotSystem.parkTheCar(vehicle);
            Object vehicle2 = new Object();
            parkingLotSystem.unParkTheCar(vehicle2);
        } catch (ParkingLotSystemException e) {
            assertEquals(ParkingLotSystemException.ExceptionType.NO_VEHICLE, e.type);
        }
    }

    @Test
    public void givenParkingLot_WhenParkingLotIsFull_thenShouldNotifyToOwner() {
        try {
            parkingLotSystem.setParkingLotCapacity(2);
            parkingLotSystem.parkTheCar(vehicle);
            Object vehicle2 = new Object();
            parkingLotSystem.parkTheCar(vehicle2);
            Object vehicle3 = new Object();
            parkingLotSystem.parkTheCar(vehicle3);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
            Assert.assertTrue(ParkingLotObserver.OWNER.isParkingFull);
        }
    }

    @Test
    public void givenParkingLot_WhenParkingLotIsFull_thenShouldNotifyToAirportSecurity() throws ParkingLotSystemException {
        try {
            parkingLotSystem.setParkingLotCapacity(2);
            parkingLotSystem.parkTheCar(vehicle);
            Object vehicle2 = new Object();
            parkingLotSystem.parkTheCar(vehicle2);
            Object vehicle3 = new Object();
            parkingLotSystem.parkTheCar(vehicle3);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_FULL, e.type);
            Assert.assertTrue(ParkingLotObserver.OWNER.isParkingFull);
            Assert.assertTrue(ParkingLotObserver.AIRPORT_SECURITY.isParkingFull);
        }
    }
}

