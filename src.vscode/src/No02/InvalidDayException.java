package No02;

public class InvalidDayException extends Exception {
    public InvalidDayException(int days) {
        super("Days Invalid");
    }
}
