import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void givenVehicle_WhenParked_ReturnTrue() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        boolean isParked = parkingLotSystem.parkVehicle(new Object());
        Assert.assertTrue(isParked);
    }
}
