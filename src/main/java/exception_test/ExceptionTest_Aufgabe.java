package exception_test;

import java.io.IOException;

public class ExceptionTest_Aufgabe {
    private void fun1() throws IOException {
        throw new IOException("level 1 exception");
    }

    private void fun2() {
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 exception", e);
        }
    }

    public static void main(String[] args) {
        try {
            new ExceptionTest_Aufgabe().fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
