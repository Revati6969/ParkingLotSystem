public class ParkingLotSystem {

    private Object vehicle;

    public boolean parkVehicle(Object vehicle) {
        if(this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    public boolean unParkVehicle(Object vehicle) {
        if(this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
