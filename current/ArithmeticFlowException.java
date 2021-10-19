package ru.gb.current;

public class ArithmeticFlowException extends RuntimeException {
    public ArithmeticFlowException(String message) {
        super(message);
    }

    public ArithmeticFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
