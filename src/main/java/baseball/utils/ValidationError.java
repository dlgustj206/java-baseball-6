package baseball.utils;

public class ValidationError extends RuntimeException{

    public ValidationError(String message) {
        super(message);
    }
}
