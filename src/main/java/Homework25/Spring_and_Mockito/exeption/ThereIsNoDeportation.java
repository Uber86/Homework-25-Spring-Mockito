package Homework25.Spring_and_Mockito.exeption;

public class ThereIsNoDeportation extends  RuntimeException {
    public ThereIsNoDeportation() {
    }

    public ThereIsNoDeportation(String message) {
        super(message);
    }

    public ThereIsNoDeportation(String message, Throwable cause) {
        super(message, cause);
    }
}
