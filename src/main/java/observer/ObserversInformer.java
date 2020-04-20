package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserversInformer {
    public List<ParkingLotObserver> observers;

    public ObserversInformer() {
        this.observers = new ArrayList();
        for (ParkingLotObserver observer: ParkingLotObserver.values()) {
            this.observers.add(observer);
        }
    }

    public void informThatParkingIsFull() {
        this.observers.forEach(observer -> observer.isParkingFull = true);;
    }

    public void informThatParkingIsAvailable() {
        this.observers.forEach(observer -> observer.isParkingFull = false);
    }
}