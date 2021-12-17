package lk.example.test.exception;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
