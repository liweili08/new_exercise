package exception_test;

import java.io.IOException;

/*
何时用try-catch-finally，何时用throws:
1. 父类被重写的方法没有用throws处理异常那子类也不能用throws，
   此时若子类重写的方法中有异常那只能用try-catch-finally来处理
2. 执行的方法a中先后又调用了几个有递进关系的方法。此时建议这几个方法使用throws
   处理异常，而执行的方法a可以考虑用try-catch-finally处理异常
3. 一个方法中try-catch-finally和throws选一个用就行了，没必要两个都用


方法重写的规则之一: 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常

; () :
 */
public class Exception_Override {
    public void display(SuperClass superClass)//这里的形参为父类
    {
        try {
            superClass.method();
        } catch (IOException e) //catch的也是父类的异常
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exception_Override test = new Exception_Override();
        test.display(new SubClass());//利用多态，这里的形参为子类
        /*
        根据多态性，通过superClass调用method方法实际是调用了子类重写的方法
        若此时恰好抛出了一个异常，若此异常比父类的异常小，在display中的catch
        是能抓住的，但如果比父类的还大，那catch就抓不住了，即没能解决所有的异常
        反过来说父类没有throws异常那子类也不能throws异常
         */


    }
}

class SuperClass {
    public void method() throws IOException {
    }
}

class SubClass extends SuperClass {
    public void method() throws IOException {

    }
}