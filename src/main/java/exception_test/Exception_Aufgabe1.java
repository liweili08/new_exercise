package exception_test;

import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

/*
异常处理: 在程序执行中发生的不正常情况，注意语法错误 和逻辑错误不算异常
    异常分2类 (异常的顶级父类为Throwable，其子类为Error和Exception)
        Error: Java虚拟机无法解决的严重问题，如JVM系统内部错误，或资源耗尽等
              StackOverflowError(栈溢出)和OOM(=OutOfMemoryError堆溢出)，
              一般不编写针对性的代码进行处理，除非改代码

        Exception: 其他因编程错误或偶然的外在原因导致的一般性问题，如空指针异常，
                  文件不存在异常，数组角标越界异常等, 可用针对性的代码进行处理
                  对于这些错误一般有2种解决方法:要么遇到错误就终止程序，要么是
                  在编写程序是就考虑到错误的检测，错误消息的提示以及错误的处理.
                  Exception又分为
                    编译时异常(IOException--FileNotFoundException)
                    运行时异常(NullPointerException，ArrayIndexOutOfBoundsException，
                             ClassCastException，NumberFormatException，
                             InputMismatchException，ArithmeticException)

 */
public class Exception_Aufgabe1 {
    //运行时异常
    @Test
    public void test1() {
        //1. NullPointerException
        //int[] array= new int[3];
        String[] array = new String[2];
        System.out.println(array[1].length());
        //int[] arr = null;
        //System.out.println(arr[3]);
    }

    @Test
    public void test2() {
        //2. ArrayIndexOutOfBoundsException or XXXIndexOutOfBoundsException
        //int[]array1= new int[2];
        //System.out.println(array1[2]);
        String str = "abc";
        System.out.println(str.charAt(3));//StringIndexOutOfBoundsException

    }

    @Test
    public void test3() {
        //3. ClassCastException 类型转换异常
        Object obj = new Date();
        String str = (String) obj;
        System.out.println(str);

    }

    @Test
    public void test4() {
        //4. NumberFormatException
        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);
        String str1 = "abc"; //因为abc本身不是数值类型
        int j = Integer.parseInt(str1);
    }

    @Test
    public void test5() {
        //5. InputMismatchException
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();
        System.out.println(score);//输入的不是数字时就会报错
        scan.close();
    }

    @Test
    public void test6() {
        //6. ArithmeticException
        int a = 10;
        System.out.println(a / 0);
    }

    ///////////////////////////////
    //编译时异常: 有红波浪线提示要加Exception的就是编译时会不通过
    @Test
    public void test7() {
        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);
//        int data=fis.read();
//        while (data!=-1)
//        {
//            System.out.print((char) data);
//            data= fis.read();
//        }
//        fis.close();
    }
}
