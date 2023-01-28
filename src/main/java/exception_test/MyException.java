package exception_test;

/*
如何自定义异常类?
1. 继承于现有的异常结构，RuntimeException和Exception
   区别是RuntimeException可以不用显示的处理异常，而Exception
   必须考虑处理的问题
2. 提供全局常量序列号 serialVersionUID 是唯一的标识这个类
3. 提供重载的构造器
: () ;
 */
public class MyException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}
