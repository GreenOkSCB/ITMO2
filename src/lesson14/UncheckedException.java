package lesson14;

public class UncheckedException extends RuntimeException{
    public UncheckedException(String message) {
        super(message);

    }
    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
    public UncheckedException() {
        super();
    }
}
