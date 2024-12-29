package exceptions;

public class MatriculAlreadyExist extends RuntimeException {
    public MatriculAlreadyExist(String message) {
        super(message);
    }
}
