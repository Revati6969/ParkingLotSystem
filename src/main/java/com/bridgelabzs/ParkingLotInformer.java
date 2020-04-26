package com.bridgelabzs;

import observer.ParkingLotObservar;

public interface ParkingLotInformer {
    void addObserver(ParkingLotObservar lotObserver);

    void notifyParkingStatus(boolean parkingStatus);
}
