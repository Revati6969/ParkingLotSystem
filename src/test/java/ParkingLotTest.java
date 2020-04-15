import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        boolean isParked =  parkingLotSystem.parkVehicle(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ReturnFalse() {
        try {
            parkingLotSystem.parkVehicle(vehicle);
            parkingLotSystem.parkVehicle(new Object());
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals("Parking is full", e.getMessage());
        }
    }

   @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotSystemException {
        parkingLotSystem.parkVehicle(vehicle);
        boolean isUnParked = parkingLotSystem.unParkVehicle(vehicle);
        Assert.assertTrue(isUnParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyUnParked_ShouldReturnFalse() throws ParkingLotSystemException {
        parkingLotSystem.parkVehicle(new Object());
        boolean isUnParked = parkingLotSystem.unParkVehicle(vehicle);
        Assert.assertFalse(isUnParked);
    }
}
