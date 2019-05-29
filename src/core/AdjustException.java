package core;

/**
 * ClassName: classname
 * Description: desc
 * Date: 2019/5/24 11:02
 *
 * @author LU
 */
public class AdjustException extends RuntimeException {

    public AdjustException() {
    }

    public AdjustException(String message) {
        super(message);
    }

    public AdjustException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdjustException(Throwable cause) {
        super(cause);
    }
}
