package parkinglotessetials;

import exceptions.ParkingLotSystemException;

import java.util.List;

public interface ParkingStrategy {
    public ParkingLotSystem getParkingLot(List<ParkingLotSystem> parkingLotList) throws ParkingLotSystemException;
}
