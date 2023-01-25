package exception_test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
在写程序时，通常要在可能出错的位置加上检测代码。
过多的if-else分支会导致程序代码过长，可读性差，因此采用异常处理
Java异常处理: 把异常处理的代码集中在一起，与正常代码分开。可使程序简洁，便于维护
异常处理模型: 抓抛模型
    过程1 抛: 程序正常执行过程中，一旦出现异常，就在异常代码处生成一个
             对应异常类的对象并将此对象抛出给程序的调用者。
             一旦抛出异常对象，其后的代码就不再执行
    过程2 抓: 异常的处理方式
             方式1: try-catch-finally
             方式2: throws+异常类型


try-catch-finally 用法:  (可以自己解决掉)
try{可能出现异常的代码}
catch(异常类型1 变量名1){ 处理异常的方式1 }
catch(异常类型2 变量名2){ 处理异常的方式2 }
catch(异常类型3 变量名3){ 处理异常的方式3 }
finally{ 一定会执行的代码 }

注意: 1.finally是可选的，不是必须要写的
        finally中声明的是一定会被执行的代码，即使
            catch中又出现异常，try中有return，catch中有return等情况
        像数据库链接，输入输出流，网络编程Socket等资源，VJM是不能自动回收的
        要求手动进行资源释放，就要放到finally中
     2.用try把可能出现异常的代码包装起来，在执行过程中，一旦出现异常，会生成一个
             对应异常类的对象，根据此对象的类型去到catch里匹配，且出现异常之后的
             代码都不执行
     3.一旦try中的异常对象匹配到某个catch时，就进入catch中进行异常的处理。
       一旦处理完成就跳出try-catch结构(在没有finally的情况下)，继续执行其后代码
     4.catch中的异常类型若没有子父类关系，则声明的位置无所谓
       catch中的异常类型是子父类关系，则要求子类一定要声明在父类的上面，否则报错
     5.常用的异常处理方式为
        1.String getMessage() 获取异常信息
        2.printStackTrace() 获取栈信息，更常用
     6.在try结构里声明的变量出了try以后就不能用了，
       解决方法: 在try之前声明并初始化变量
     7.try-catch可以嵌套

使用try-catch-finally处理编译时异常使得程序在编译时不再报错，但运行时仍可能报错
相当于将一个编译时可能出现的异常延迟到运行时

throws+异常类型: (当前解决不了往上抛)
*/
public class Exception_Try_Catch {
    @Test
    public void test1() {
        String str = "abc";
        int num = 0;
        try {
            //int num = Integer.parseInt(str);
            num = Integer.parseInt(str);
            System.out.println("Hello----1");
        } catch (NumberFormatException e) {
            System.out.println("Fehler!");
            //System.out.println(e.getMessage());
            // e.printStackTrace();
        }
        System.out.println("Hello*******2");
        System.out.println(num);
    }

    @Test
    public void test2() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test3() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            //e.printStackTrace();
            int[] arr = new int[10];
            System.out.println(arr[10]);
        }
        //System.out.println("lololo");
        finally {
            System.out.println("lalala");
        }

    }

    @Test
    public void test4() {
        int num = method();
        System.out.println(num);
    }

    public int method() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("miumiumiu");
        }
    }

    @Test
    public void test5() {

    }
}
