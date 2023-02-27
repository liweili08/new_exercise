package Lambda_Aufgabe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
1. 函数式接口: 只声明了一个抽象方法的接口。
2. 在java.util.function 包里有很多函数式接口
3. Java内置的四大核心函数式接口:
    函数式接口            参数类型 返回类型 用途
    --------------------------------------------------------
    Consumer<T>消费型接口    T    void  对类型为T的对象应用操作，如 void accept(T t)
    Supplier<T>供给型接口    无     T   返回类型为T的对象，如 T get()
    Function<T，R>函数型接口  T     R   对类型为T的对象应用操作，并返回类型为R的对象，如 R applz(T t)
    Predicate<T>判断型接口   T  boolean 判断类型为T的对象是否满足某约束并返回boolean值，如 boolean test(T t)





<>
; : ( ) //
 */
public class Functional_Interface_Aufgabe {
    @Test
    public void test1() {
        happyTime(500, money -> System.out.println("消费" + money));
//        happyTime(500, new Consumer<Double>() {
//            @Override
//            public void accept(Double aDouble) {
//                System.out.println("消费"+aDouble);
//            }
//        });
    }

    //包含Consumer<T>消费型接口 的方法
    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> stringList = new ArrayList<>();
        stringList.add("AA");
        stringList.add("A12");
        stringList.add("BB");
        stringList.add("213123A");
        //List<String> stringList = Arrays.asList("A","B");

        List<String> strings = filterString(stringList, s -> s.contains("A"));


//        List<String> strings = filterString(stringList, new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.contains("A");
//            }
//        });

        System.out.println(strings);

    }

    //根据给定的规则过滤集合中的字符串，规则是由Predicate的test方法决定的
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> filterList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                filterList.add(str);
            }
        }
        return filterList;
    }
}
