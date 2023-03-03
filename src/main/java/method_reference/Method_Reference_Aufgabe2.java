package method_reference;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
1. 构造器引用:与方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
            抽象方法的返回值类型即为构造器所属类的类型
2. 数组引用: 把数组看出特殊的类，则写法与构造器引用一致，可以new新的数组

; : ( )
 */
public class Method_Reference_Aufgabe2 {
    //构造器引用
    // Supplier中的T get()
    //Employee_Reference的空参构造器 Employee_Reference()
    @Test
    public void test1() {
        Supplier<Employee_Reference> sup1 = () -> new Employee_Reference();
//        Supplier<Employee_Reference> sup = new Supplier<Employee_Reference>() {
//            @Override
//            public Employee_Reference get() {
//                return new Employee_Reference();
//            }
//        };
        System.out.println(sup1.get());
        System.out.println("**********************");
        Supplier<Employee_Reference> sup2 = Employee_Reference::new;
        System.out.println(sup2.get());
    }

    //构造器引用
    // Function中的R apply(T t)
    //Employee_Reference的带参构造器 Employee_Reference()
    @Test
    public void test2() {
        Function<Integer, Employee_Reference> func1 = id -> new Employee_Reference(id);
        System.out.println(func1.apply(1003));

        Function<Integer, Employee_Reference> func2 = Employee_Reference::new;
        System.out.println(func2.apply(1004));
    }

    //构造器引用
    //BiFunction中的R apply(T t,U u)
    //Employee_Reference的带参构造器 Employee_Reference()
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee_Reference> func1 = (id, name) -> new Employee_Reference(id, name);
        System.out.println(func1.apply(1003, "Rose"));

        BiFunction<Integer, String, Employee_Reference> func2 = Employee_Reference::new;
        System.out.println(func2.apply(1004, "Jerry"));
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] str = func1.apply(5);
        System.out.println(Arrays.toString(str));
//        for (String s:str)
//        {
//            System.out.println(s);
//        }
        System.out.println("****************");
        Function<Integer, String[]> func2 = String[]::new;
        String[] string = func2.apply(2);
        System.out.println(Arrays.toString(string));

    }


}
