package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Stream的中间操作二 映射
1. map(Function f) 接受一个函数作为参数，该函数会应用到每个元素上，并将其映射成一个新元素
2. mapToDouble(ToDoubleFunction f) .....................,产生一个新的DoubleStream
3. mapToint(TointFunction f)       .....................,产生一个新的IntStream
4. mapToLong(ToLongFunction f)     .....................,产生一个新的LongStream
5. flatMap(Function f) 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

; : () //
 */
public class Stream_Aufgabe3 {
    //
    @Test
    public void test1() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 42, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));

        Stream<Employee_Reference> stream1 = employees.stream();
        stream1.map(Employee_Reference::getName).filter(name -> name.length() > 3).forEach(System.out::println);

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<String> stream = list.stream();
        stream.map(str -> str.toUpperCase()).forEach(System.out::println);


    }

    //flatMap(Function f)
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Stream<Character>> streamStream = list.stream().map(Stream_Aufgabe3::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println("*******************");
        Stream<Character> characterStream = list.stream().flatMap(Stream_Aufgabe3::fromStringToStream);
        characterStream.forEach(System.out::println);


    }

    //将字符串str中的字符构成的集合转换为对应Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
