package day4;


public class AgeRunException extends RuntimeException{
    public AgeRunException(String message) {
        super(message);
    }

    public AgeRunException(String message, Throwable cause) {
        super(message, cause);
    }
}
