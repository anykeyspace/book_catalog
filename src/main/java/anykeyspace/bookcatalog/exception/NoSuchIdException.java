package anykeyspace.bookcatalog.exception;

/**
 * No such ID in DB exception
 */
public class NoSuchIdException extends RuntimeException {

    public NoSuchIdException(String message) {
        super(message);
    }
}
