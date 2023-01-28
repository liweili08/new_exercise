package exception_test;

public class NegativeException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766938L;

    public NegativeException() {
    }

    public NegativeException(String msg) {
        super(msg);
    }

}
