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
    Consumer<T>消费型接口    T    void  对类型为T的对象应用操作，接口中的抽象方法为 void accept(T t)
    Supplier<T>供给型接口    无     T   返回类型为T的对象，接口中的抽象方法为 T get()
    Function<T, R>函数型接口  T     R   对类型为T的对象应用操作，并返回类型为R的对象，接口中的抽象方法为 R apply(T t)
    Predicate<T>断定型接口   T  boolean 判断类型为T的对象是否满足某约束并返回boolean值，接口中的抽象方法为 boolean test(T t)

除此之外还有一些变形，比如
    函数式接口          参数类型 返回类型 用途
    --------------------------------------------------------
    BiFunction<T,U,R>  T,U    R     对类型为T,U的对象应用操作,返回对象为R型，接口中的抽象方法为 R apply(T t，U u)
    --------------------------------------------------------
    UnaryOperator<T>   T      T     对类型为T的对象进行一元运算，并返回类型为T的对象
     (Function子接口)                接口中的抽象方法为 T apply(T t)
     --------------------------------------------------------
    BinaryOperator<T>  T      T     对类型为T的对象进行二元运算，并返回类型为T的对象，
    (BiFunction子接口)               接口中的抽象方法为 T apply(T t1，T t2)
    --------------------------------------------------------
    BiConsumer<T,U>    T,U  void    对类型为T，U的对象应用操作，没有返回对象，接口中的抽象方法为 void accept(T t，U u)
    --------------------------------------------------------
    BiPredicate<T,U>   T,U  boolean 判断类型为T的对象是否满足某约束并返回boolean值，接口中的抽象方法为boolean test(T t,U u)
    --------------------------------------------------------
    ToIntFunction<T>        int
    ToLongFunction<T>   T   long    分别计算int,long,double值的函数
    ToDoubleFunction<T>     double
    --------------------------------------------------------
    IntFunction<R>    int     R
    LongFunction<R>   long    R     参数分别为int,long,double类型的函数
    DoubleFunction<R> double  R


如果要定义的接口与上述接口的抽象方法一样，比如需要参数，返回是void，就没有必要再去定义了，
直接用Consumer接口里的accept方法就可以了

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
