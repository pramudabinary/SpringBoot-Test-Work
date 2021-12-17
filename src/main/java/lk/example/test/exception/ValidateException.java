package lk.example.test.exception;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/

public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
