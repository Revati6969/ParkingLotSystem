import com.bridgelabzs.ParkingLotSystem;
import com.bridgelabzs.PoliceDepartment;
import com.bridgelabzs.Vehicle;
import exceptions.ParkingLotSystemException;
import observer.AirportSecurity;
import observer.ParkingLotOwner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ParkingLotTest {
    ParkingLotSystem parkingLotSystem = null;
    Vehicle vehicle = null;
    ParkingLotOwner parkingLotOwner = null;
    AirportSecurity airportSecurity = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date();

    @Before
    public void setUp() {
        parkingLotSystem = new ParkingLotSystem(2, 3);
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
    }

    @Test
    public void givenAVehicleToPark_WhenParkedInParkingLot_ShouldReturnTrue() {
        try {
            vehicle = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
            parkingLotSystem.park(vehicle);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParkedInParkingLot_ShouldThrowException() {
        parkingLotSystem = new ParkingLotSystem(3, 3);
        try {
            parkingLotSystem.park(new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE));
            parkingLotSystem.park(new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE));
            parkingLotSystem.park(new Vehicle("3", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE));
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotParkedInParkingLot_ShouldReturnFalse() {
        vehicle = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
        Assert.assertFalse(isPark);
    }

    @Test
    public void givenAVehicle_WhenUnParkedFromParkingLot_ShouldReturnTrue() {
        try {
            Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.unPark(vehicleOne);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicleOne);
            Assert.assertTrue(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenNoVehicleUnParked_ShouldThrowException() {
        try {
            Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
            Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.isVehicleUnPark(vehicleOne);
            parkingLotSystem.unPark(vehicleTwo);

        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.NOT_PARKED_HERE, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotUnParked_ShouldReturnFalse() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicleOne);
            Assert.assertFalse(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenThereIsSpace1inParkingLot_ShouldAllowToPark() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleThree = new Vehicle("3", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleTwo);
            parkingLotSystem.unPark(vehicleTwo);
            parkingLotSystem.park(vehicleThree);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicleThree);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldThrowException() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL,Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleOne);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.VEHICLE_ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenAskForPosition_ShouldReturnPosition() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            String vehiclePosition = parkingLotSystem.getVehiclePosition(vehicleOne);
            Assert.assertEquals("A1 1", vehiclePosition);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenToPark_ShouldReturnParkingDateTime() {
        vehicle = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicle);
            String dateTime = formatter.format(date);
            String parkingDateAndTime = vehicle.getParkingDateAndTime();
            Assert.assertEquals(dateTime, parkingDateAndTime);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicles_WhenParkedInParkingLot_ShouldEvenlyDistributeInParkingLot() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleTwo);
            String vehicle1Position = parkingLotSystem.getVehiclePosition(vehicleOne);
            String vehicle2Position = parkingLotSystem.getVehiclePosition(vehicleTwo);
            Assert.assertEquals("A1 1", vehicle1Position);
            Assert.assertEquals("A2 1", vehicle2Position);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenDriverIsHandicap_ShouldParkVehicleAtNearestLotPosition() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleThree = new Vehicle("3", Vehicle.DriverType.HANDICAP, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleTwo);
            parkingLotSystem.unPark(vehicleOne);
            parkingLotSystem.park(vehicleThree);
            String vehicle1Position = parkingLotSystem.getVehiclePosition(vehicleThree);
            Assert.assertEquals("A1 1", vehicle1Position);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleOfLargeSize_WhenMaximumNumberOfParkingSlotAvailable_ShouldParkedInThatParkingLot() {
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleThree = new Vehicle("3", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleFour = new Vehicle("4", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.LARGE, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleTwo);
            parkingLotSystem.park(vehicleThree);
            parkingLotSystem.park(vehicleFour);
            String vehicleFourPosition = parkingLotSystem.getVehiclePosition(vehicleFour);
            Assert.assertEquals("A2 2", vehicleFourPosition);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLotMap_WhenNeedInformationAsPerVehicleColour_ShouldReturnVehicleMapWithRespectiveColour() {
        PoliceDepartment policeDepartment = new PoliceDepartment(parkingLotSystem);
        Vehicle vehicleOne = new Vehicle("1", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleTwo = new Vehicle("2", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        Vehicle vehicleThree = new Vehicle("3", Vehicle.DriverType.NORMAL, Vehicle.VehicleSize.SMALL, Vehicle.VehicleColour.WHITE);
        try {
            parkingLotSystem.park(vehicleOne);
            parkingLotSystem.park(vehicleTwo);
            parkingLotSystem.park(vehicleThree);
            Map<String, Vehicle> vehiclesOfColour = policeDepartment.getVehicles(Vehicle.VehicleColour.WHITE);
            Assert.assertEquals(3, vehiclesOfColour.size());
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }
}

