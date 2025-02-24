package exceptions;

public class MatriculAlreadyExistException extends RuntimeException {
    public MatriculAlreadyExistException(String message) {
        super(message);
        
    }
}
