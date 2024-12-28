package exceptions;

public class VehiculeNotFound extends RuntimeException {
    public VehiculeNotFound(String message) {
        super(message);
    }
}
