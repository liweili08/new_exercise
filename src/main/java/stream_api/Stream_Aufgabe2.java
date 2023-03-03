package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/*
Stream的中间操作一 筛选与切片
1. filter(Predicate p) 从流中排除某些元素
2. limit(n) 截断一个流，使其元素个数不超过给定数量
3. skip(n) 跳过元素，返回一个去掉前n个元素的流，若流中元素不足n个，则返回一个空流
4. distinct() 筛选，通过流所生成元素的hashCode()和equals()去掉重复元素

; : ()
 */
public class Stream_Aufgabe2 {
    // filter(Predicate p) 从流中排除某些元素
    @Test
    public void test1() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        Stream<Employee_Reference> stream = employees.stream();

        // 查询员工表中工资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        //Predicate<Employee_Reference> pre1 = e-> e.getSalary()>7000;
//        Predicate<Employee_Reference> pre = new Predicate<Employee_Reference>() {
//            @Override
//            public boolean test(Employee_Reference employee_reference) {
//                return employee_reference.getSalary()>7000;
//            }
//        };

    }

    //limit(n) 截断一个流，使其元素个数不超过给定数量
    @Test
    public void test2() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        //上一个stream不能直接拿来用，要重新实例化一个stream
        //stream.limit(3).forEach(System.out::println);直接用会报错
        Stream<Employee_Reference> stream1 = employees.stream();
        stream1.limit(3).forEach(System.out::println);
    }

    // skip(n) 跳过元素，返回一个去掉前n个元素的流，若流中元素不足n个，则返回一个空流
    @Test
    public void test3() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        Stream<Employee_Reference> stream = employees.stream();
        stream.skip(3).forEach(System.out::println);
        //stream.skip(30).forEach(System.out::println);
    }

    //distinct() 筛选，通过流所生成元素的hashCode()和equals()去掉重复元素
    @Test
    public void test4() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 42, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        employees.add(new Employee_Reference(1010, "Liu", 40, 8000));
        Stream<Employee_Reference> stream = employees.stream();
        //System.out.println(employees);
        stream.distinct().forEach(System.out::println);

    }
}
