package ru.gb.current;

public class CustomArithmeticalException extends Exception {
    public CustomArithmeticalException(String message) {
        super(message);
    }

    public CustomArithmeticalException(String message, Throwable cause) {
        super(message, cause);
    }
}
