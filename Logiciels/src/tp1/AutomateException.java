package tp1;

/**
 * The class that handles the exception related to automata.
 */
public class AutomateException extends Exception {
    /**
     * The exception which is activated if the parsed character string is incorrect.
     */
    public String AutomateException() {
        return super.getMessage();
    }
}
