package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
1. Stream API(java.util.stream)把函数式编程引入Java中，
   可以对指定集合进行查找，过滤和映射数据等操作
2. 使用Stream API对集合数据进行操作类似于使用SQL执行的数据库查询，
   但是是在Java层面操作，不是在DB里操作
3. Stream与Collection的区别:
   - Collection是一种静态的内存数据结构，主要面向内存，存储在内存中
   - Stream是操作内存中的数据进行计算的，主要面向CPU，通过CPU实现计算
4. 注意:
   (1) Stream自己不储存数据
   (2) Stream不会改变源数据，相反，他们会返回一个持有结果的新Stream
   (3) Stream操作是延迟的，即他们会等到需要结果时才会执行
5. Stream的操作分3个步骤:
   (1) 创建Stream实例: 一个数据源如集合，数组，获取一个流
   (2) 中间操作: 一个中间操作链，对数据源的数据进行处理
   (3) 终止操作: 一旦执行终止操作，就执行中间操作链并生成结果，此后该Stream对象不会被再次使用
6. 说明:
   (1) 中间操作链可以有多个操作filter，map等
   (2) 延迟性以及不可重复使用，若要用则必须重新创建新的Stream对象

 */
public class Stream_Aufgabe1 {
    /*
    Stream实例化方式1: 通过集合
    用集合的默认方法 default Stream<E> stream(): 返回顺序流或
                  default Stream<E> paralleStream(): 返回并行流
    顺序流与并行流区别:
    顺序流在之后的操作中会按照集合中的顺序来依次操作数据
    并行流会同时操作数据
     */
    @Test
    public void test1() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        Stream<Employee_Reference> stream = employees.stream();

        Stream<Employee_Reference> stream1 = employees.parallelStream();
    }

    /*
    Stream实例化方式2: 通过数组
    用Arrays的静态方法stream()
        static <T> Stream<T> stream(T[] array): 返回一个流
     */
    @Test
    public void test2() {
        int[] arr = new int[]{12, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee_Reference e1 = new Employee_Reference(1001, "Tom");
        Employee_Reference e2 = new Employee_Reference(1002, "Jerry");
        Employee_Reference[] emp = new Employee_Reference[]{e1, e2};
        Stream<Employee_Reference> stream1 = Arrays.stream(emp);
    }

    /*
   Stream实例化方式3: 通过Stream类本身的静态方法of()
      public static <T> Stream<T> of(T... values): 返回一个流
    */
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /*
Stream实例化方式4: 创建无限流
  通过静态方法Stream.iterate()和Stream.generate(),返回一个无限流
  迭代:
  public static <T> Stream<T> iterate(final T seed, final UnaryOperator <T>)
  生成:
  public static <T> Stream<T> generate(Supplier<T> s)
*/
    @Test
    public void test4() {
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
