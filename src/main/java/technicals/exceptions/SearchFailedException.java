package technicals.exceptions;

public class SearchFailedException extends RuntimeException {
    public SearchFailedException(String message) {
        super(message);
    }
}
