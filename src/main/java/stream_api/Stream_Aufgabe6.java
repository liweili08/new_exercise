package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
Stream的终止操作二: 归约
方法                                  描述
----------------------------------------------------------------
reduce(T identity, BinaryOperator b) 可将流中元素反复结合起来(比如求和)，得到一个值，返回T
reduce(BinaryOperator b)             可将流中元素反复结合起来，得到一个值，返回Optional<T>
注意: map和reduce的连接称为map-reduce模式，因Google用它进行网络搜索而出名

; : () //
 */
public class Stream_Aufgabe6 {
    @Test
    public void test1() {
        //reduce(T identity, BinaryOperator b): identity相当于初始值
        //练习: 计算1到10的自然数之和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator b):
        //练习: 计算所有员工工资的总和
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        //Optional<Double> salarySum = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> salarySum = salaryStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(salarySum);
    }
}
