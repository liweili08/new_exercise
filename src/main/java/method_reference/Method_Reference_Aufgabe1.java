package method_reference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
1. 当要传递给Lambda体的操作已有实现的方法时可以用方法引用
2. 方法引用就是Lambda表达式，也是函数式接口的实例，是通过方法的名字来指向一个方法
3. 要求: 实现接口的抽象方法的参数列表和返回值类型必须与方法引用的方法的参数列表和返回值类型一致
4. 格式: 使用 :: 把类(或对象)与方法名分隔开，即 调用者::方法名
5. 主要使用情况有:
   情况1 对象::实例方法名
   情况2 类::静态方法名
   情况3 类::实例方法名
6. 使用的要求: 要求函数类接口中的抽象方法的形参列表和返回值类型要与
             方法引用的方法的形参列表和返回值类型相同(指情况1和情况2)

; : ( ) //
 */
public class Method_Reference_Aufgabe1 {
    //情况1 对象::实例方法名
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

    //情况1 对象::实例方法名
    //Supplier中的 T get() -> Employee_Reference中的 String getName()
    @Test
    public void test2() {
        Employee_Reference emp1 = new Employee_Reference(1001, "Tom", 23, 5600);
        Supplier<String> supplier = () -> emp1.getName();
        System.out.println(supplier.get());
        System.out.println("*********************************");
        Supplier<String> supplier1 = emp1::getName;
        System.out.println(supplier1.get());

//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return emp1.getName();
//            }
//        };
    }


    //情况2 类::静态方法名
    //Comparator中的 int compare(T t1,T t2) -> Integer中的 int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
//        Comparator<Integer> comparator1 = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        };
        System.out.println(com1.compare(12, 21));
        System.out.println("*********************************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(13, 31));
    }

    //情况2 类::静态方法名
    //Function中的 R apply(T t) -> Math中的Long round (Double d)
    @Test
    public void test4() {
        Function<Double, Long> func1 = d -> Math.round(d);
//        Function<Double, Long> func1 = new Function<Double, Long>() {
//            @Override
//            public Long apply(Double aDouble) {
//                return Math.round(aDouble);
//            }
//        };
        System.out.println(func1.apply(3.45));
        System.out.println("****************");
        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(55.44444));

    }

    //情况3 类::非静态方法名
    //Comparator中的 int compare(T t1,T t2) -> String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        Comparator<String> com1 = (t1, t2) -> t1.compareTo(t2);
//        Comparator<String> com = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        };

        System.out.println(com1.compare("abc", "abd"));
        System.out.println("******************************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("acd", "fdd"));
    }


    //情况3 类::非静态方法名
    //BiPredicate中的 boolean test(T t1,T t2) -> String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<String, String> biPre2 = (s1, s2) -> s1.equals(s2);
//        BiPredicate<String, String> biPre1 = new BiPredicate<String, String>() {
//            @Override
//            public boolean test(String s1, String s2) {
//                return s1.equals(s2);
//            }
//        };
        System.out.println(biPre2.test("adsa1", "as1"));
        System.out.println("*******************************");
        BiPredicate<String, String> biPre3 = String::equals;
        System.out.println(biPre3.test("abc", "abc"));
    }

    //情况3 类::非静态方法名
    //Function中的 R apply(T t) -> Employee_Reference中的String getName()
    @Test
    public void test7() {
        Employee_Reference emp = new Employee_Reference(1002, "Jack", 18, 3000);
        Function<Employee_Reference, String> func = e -> e.getName();
//        Function<Employee_Reference,String> func1 = new Function<Employee_Reference, String>() {
//            @Override
//            public String apply(Employee_Reference employee) {
//                return employee.getName();
//            }
//        };
        System.out.println(func.apply(emp));
        System.out.println("********************");
        Function<Employee_Reference, String> func1 = Employee_Reference::getName;
        System.out.println(func1.apply(emp));
    }


}

