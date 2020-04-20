package exceptions;

public class ParkingLotSystemException extends Exception {

    public ExceptionType type;

    public ParkingLotSystemException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType{
        PARKING_FULL,
        NO_VEHICLE,
        CAR_ALREADY_PARKED
    }
}
