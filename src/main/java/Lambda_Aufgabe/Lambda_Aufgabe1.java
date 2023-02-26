package Lambda_Aufgabe;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/*
1. 例子: (o1,o2) -> Integer.compare(o1,o2);
2. 格式: -> Lambda操作符(箭头操作符)
        箭头左边是Lambda形参列表(其实就是接口中抽象方法的形参列表，可省略类型也可不省略)
        箭头右边是Lambda体(其实就是重写的抽象方法的方法体)
3. Lambda表达式的使用:
    1. 无参无返回值，见Test1
    2. Lambda需要1个参数，但是无返回值，
        Consumer<String> consumer1 = (String s) -> {System.out.println(s);};
    3. 数据类型可以省略，因为可以由编译器推断而出，成为类型推断
        Consumer<String> consumer1 = (s) -> {System.out.println(s);};
    4. Lambda只需要1个参数时，参数的小括号也可以省略
        Consumer<String> consumer1 = s -> {System.out.println(s);};
    5. Lambda需要2个或以上的参数，多条执行语句，且可以有返回值, 见Test4
    6. 当Lambda只有1条语句时，return与花括号若有则都可省略, 见Test5

总结:
    箭头左边: Lambda形参列表的参数类型可以省略(类型推断)，
            若Lambda形参列表只有一个参数，小括号可以省略
    箭头右边: Lambda体应使用小括号，若Lambda体只有一行(可能是return)，
            则可省略花括号和return

4. Lambda表达式的本质: 作为接口的实现类的实例，接口必须是函数式接口
   (函数式接口)


; : ( ) //
 */
public class Lambda_Aufgabe1 {
    @Test
    public void test5() {
        Comparator<Integer> comparator1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(12, 21));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%");
        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
    }

    @Test
    public void test4() {
        Comparator<Integer> comparator1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(12, 21));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%");
        Comparator<Integer> comparator2 = (o1, o2) ->
        {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
    }

    @Test
    public void test3() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Lalala");

        System.out.println("%%%%%%%%%%%%%%%%%%%%%");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("Hahaha");

    }

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Beijing");
            }
        };//这里r1是Runnable接口的匿名实现类
        r1.run();
        System.out.println("%%%%%%%%%%%%%%%");

        Runnable r2 = () -> System.out.println("Nanjing");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator1.compare(12, 21));
        System.out.println("%%%%%%%%%%%%%%%");
        // with Lambda
        Comparator<Integer> comparator2 =
                (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator2.compare(32, 21));

        System.out.println("%%%%%%%%%%%%%%%");
        // with method reference 方法引用::
        Comparator<Integer> comparator3 = Integer::compare;
        System.out.println(comparator3.compare(32, 21));
    }
}
