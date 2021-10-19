package ru.gb.current;

public class Main {

    public static void main(String[] args) {
        doExceptionCatch();
    }

    static void doExceptionCatch() {
        causeNumberFormatException();
    }

    static void causeNumberFormatException() {
        printInt("1");
        printInt("1a");
        printInt("2");
    }

    static void printInt(String value) {
        try {
            System.out.println(parseInt(value));
        } catch (CustomArithmeticalException e) {
            throw new ArithmeticFlowException("During arithmetic parsing something went wrong", e);
        } finally {
            System.out.println("END");
        }
    }

    static int parseInt(String value) throws CustomArithmeticalException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
//            System.out.println("Val: " + value);
//            System.out.println("Name: " + e.getClass().getName());
//            System.out.println("Msg: " + e.getMessage());
//            System.out.println("Cause: " +  e.getCause());
            throw new CustomArithmeticalException("String value is not parsable integer.", e);
        }
    }

}
