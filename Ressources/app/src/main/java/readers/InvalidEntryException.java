package readers;

/**
 * Created by richa on 09/04/2018.
 */

public class InvalidEntryException extends Exception {
    public InvalidEntryException() {}
    public void display() {
        System.err.println("Invalid Stat Entry");
    }
}
