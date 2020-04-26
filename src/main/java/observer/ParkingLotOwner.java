package observer;

import com.bridgelabzs.ParkingLotSystem;

public class ParkingLotOwner implements ParkingLotObservar{
    //FIELDS
    ParkingLotSystem parkingLotSystem;
    private boolean isParkingFull;

    public ParkingLotOwner() {
        parkingLotSystem = new ParkingLotSystem();
    }

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}
