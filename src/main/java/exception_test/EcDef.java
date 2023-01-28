package exception_test;

public class EcDef extends Exception {
    static final long serialVersionUID = -7035897190745766938L;

    public EcDef() {
    }

    public EcDef(String msg) {
        super(msg);
    }
}
