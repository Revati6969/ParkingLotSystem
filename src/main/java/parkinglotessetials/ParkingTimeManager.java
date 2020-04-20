package parkinglotessetials;

import java.time.LocalDateTime;

public class ParkingTimeManager {
    private Object vehicle;

    public LocalDateTime getParkTime(Object vehicle) {
        this.vehicle = vehicle;
        return LocalDateTime.now();
    }
}
