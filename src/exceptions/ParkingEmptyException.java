package exceptions;

public class ParkingEmptyException extends RuntimeException {
    public ParkingEmptyException(String message) {
        super(message);
    }
}
