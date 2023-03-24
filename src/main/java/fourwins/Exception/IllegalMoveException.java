package fourwins.Exception;

/**
 * The exception that is thrown when a player tries to make an illegal move.
 */

public class IllegalMoveException extends Exception {
    public IllegalMoveException() {
    }

    public IllegalMoveException(String message) {
        super(message);
    }

    public IllegalMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMoveException(Throwable cause) {
        super(cause);
    }

    public IllegalMoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
