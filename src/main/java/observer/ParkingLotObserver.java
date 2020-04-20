package observer;

public enum ParkingLotObserver {

    OWNER(true), AIRPORT_SECURITY(true);
    public boolean isParkingFull;

    ParkingLotObserver(boolean isParkingFull) {
        this.isParkingFull = isParkingFull;
    }
}
