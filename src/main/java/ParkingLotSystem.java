public class ParkingLotSystem {

    private Object vehicle;

    public boolean parkVehicle(Object vehicle) {
        if(this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }
}
