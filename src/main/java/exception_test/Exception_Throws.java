package exception_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
异常的处理方式2: throws+异常类型
    在方法声明处加上throws，指明此方法执行时可能会出现的异常类型。
    一旦方法执行时出现异常，会在异常代码处自动生成一个异常对象，此对象满足throws
    后的异常类型时，就被抛出。且后续代码不再执行
注意: 1.throws的方式只是把异常抛给了方法的调用者，并没有真正的把异常处理掉，在方法
       的调用者那里还会有异常出现
     2. try-catch-finally是真的把异常处理掉了

: () ;
 */
public class Exception_Throws {

    public static void method2() throws FileNotFoundException, IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.tex");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (FileNotFoundException e) {
            System.out.println("没找到文件");
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("别的错误");
            e.printStackTrace();
        }
    }
}
