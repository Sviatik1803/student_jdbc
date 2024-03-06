package ua.sviatik.exceptions;

public class CustomSQLException extends RuntimeException {
    public CustomSQLException(Throwable cause) {
        super(cause);
    }
}
