import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLotSystem parkingLotSystem = null;
    Object Vehicle = null;

    @Before
    public void setUp() throws Exception {
        Vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    public void givenVehicle_WhenParked_ReturnTrue() {
        boolean isParked = parkingLotSystem.parkVehicle(Vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ReturnFalse() {
        parkingLotSystem.parkVehicle(Vehicle);
        boolean isParked = parkingLotSystem.parkVehicle(new Object());
        Assert.assertFalse(isParked);
    }
}
