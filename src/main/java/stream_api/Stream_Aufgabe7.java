package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/*
Stream的终止操作三: 收集(比如一个集合经过映射等操作之后有多个数据，可以用集合收集起来)
collect(Collector c) 将流转换为其他形式，接受一个Collector接口的实现，用于给Stream中元素做汇总的方法
Collector接口中方法的实现决定了如何对流执行收集的操作(如收集到List，Set，Map)
另外，Collectors实用类提供了很多静态方法，调用其静态方法可以得到Collector:

方法            返回类型              作用
---------------------------------------------------------------------------
toList         List<>               把流中元素收集到List
用法为 list.stream().collect(Collectors.toList());
---------------------------------------------------------------------------
toSet          Set<>                把流中元素收集到Set
用法为 list.stream().collect(Collectors.toSet());
---------------------------------------------------------------------------
toCollection   Collection<>         把流中元素收集到Collection
用法为 list.stream().collect(Collectors.toCollection(ArrayList::new));
---------------------------------------------------------------------------
counting       Long                 计算流中元素的个数
用法为 list.stream().collect(Collectors.counting());
---------------------------------------------------------------------------
summingInt     Integer              对流中元素的整数属性求和
用法为 list.stream().collect(Collectors.summingInt(Employee::getSalary));
---------------------------------------------------------------------------
averagingInt   Double               计算流中元素Integer属性的平均值
用法为 list.stream().collect(Collectors.averagingInt(Employee::getSalary));
---------------------------------------------------------------------------
summarizingInt IntSummaryStatistics 收集流中Integer属性的统计值，如平均值
用法为 list.stream().collect(Collectors.summarizingInt(Employee::getSalary));

; : // () <>
 */
public class Stream_Aufgabe7 {
    @Test
    public void test1() {
        //练习: 查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        List<Employee_Reference> list = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
