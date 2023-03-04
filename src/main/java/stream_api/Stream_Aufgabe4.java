package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
Stream的中间操作三 排序
sorted() 产生一个新流，其中按自然序排序
sorted(Comparator com)  产生一个新流，其中按比较器顺序排序

; : () //
 */
public class Stream_Aufgabe4 {
    @Test
    public void teat1() {
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因是Employee_Reference这个类没有实现Comparable接口
        //List<Employee_Reference> employees = Employee_Data.getEmployee();
        //employees.stream().sorted().forEach(System.out::println);
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        //employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
        employees.stream().sorted((e1, e2) ->
        {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
