package com.bridgelabzs;

import observer.ParkingLotObservar;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager implements ParkingLotInformer{
    private List<ParkingLotObservar> lotObservers;

    public ParkingLotManager() {
        lotObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(ParkingLotObservar lotObserver) {
        lotObservers.add(lotObserver);
    }

    @Override
    public void notifyParkingStatus(boolean parkingStatus) {
        for (ParkingLotObservar lotObserver : lotObservers) {
            lotObserver.updateParkingStatus(parkingStatus);
        }
    }

}
