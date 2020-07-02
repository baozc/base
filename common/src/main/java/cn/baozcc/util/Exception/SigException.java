package cn.baozcc.util.Exception;

/**
 * @author baozc
 * @date 2019/7/22 5:39 PM
 */
@SuppressWarnings("unused")
public class SigException extends RuntimeException {

    public SigException() {
        super();
    }

    public SigException(String message) {
        super(message);
    }

    public SigException(String message, Throwable cause) {
        super(message, cause);
    }

    public SigException(Throwable cause) {
        super(cause);
    }
}
