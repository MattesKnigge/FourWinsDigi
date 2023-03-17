package fourwins.Exception;

public class ColumnFullException extends Exception {

    public ColumnFullException() {
    }

    public ColumnFullException(String message) {
        super(message);
    }

    public ColumnFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnFullException(Throwable cause) {
        super(cause);
    }

    public ColumnFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
