package method_reference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/*
1. 当要传递给Lambda体的操作已有实现的方法时可以用方法引用
2. 方法引用就是Lambda表达式，也是函数式接口的实例，是通过方法的名字来指向一个方法
3. 要求: 实现接口的抽象方法的参数列表和返回值类型必须与方法引用的方法的参数列表和返回值类型一致
4. 格式: 使用 :: 把类(或对象)与方法名分隔开，即 调用者::方法名
5. 主要使用情况有:
   对象::实例方法名
   类::静态方法名
   类::实例方法名

; : ( ) //
 */
public class Method_Reference_Aufgabe1 {
    //对象::实例方法名
    //Consumer中的 void accept(T t) -> PrintStream中的 void println(T t)
    @Test
    public void test1() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Beijing");
        System.out.println("********************************");
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("Nanjing");

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
    }

}
