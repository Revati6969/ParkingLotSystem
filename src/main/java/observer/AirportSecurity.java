package observer;

public class AirportSecurity implements ParkingLotObservar{
    private Boolean isParkingFull;

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}
