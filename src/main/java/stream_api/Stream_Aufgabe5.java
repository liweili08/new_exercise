package stream_api;

import method_reference.Employee_Data;
import method_reference.Employee_Reference;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
Stream的终止操作
1. 终止操作会从流的流水线生成结果，其结果可以是任何不是流的值，如List，Integer，甚至是void
2. 流进行了终止操作后不可再次使用

Stream的终止操作一 匹配与查找
方法                          描述
————————————————————————————————————————
allMatch(Predicate p)   检查是否匹配所有元素
anyMatch(Predicate p)   检查是否至少匹配一个元素
noneMatch(Predicate p)  检查是否没有匹配所有元素
findFirst()             返回第一个元素
findAny()               返回当前流中的任意元素
count()                 返回流中元素的总个数
max(Comparator c)       返回流中的最大值
min(Comparator c)       返回流中的最小值
forEach(Consumer c)     内部迭代，之前用iterator做的迭代称为外部迭代

; : () //
 */
public class Stream_Aufgabe5 {
    @Test
    public void test1() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();

        //allMatch(Predicate p): 检查是否匹配所有元素，对所有的元素判断后都是true才返回true
        //                       否则只要有false就返回false
        //练习:是否所有的员工的年龄都大于18岁
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        System.out.println("*****************************");
        //anyMatch(Predicate p): 检查是否至少匹配一个元素，只要有一个匹配就算成功
        //练习: 是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        System.out.println("*****************************");
        //noneMatch(Predicate p): 检查是否没有匹配所有元素
        //练习: 是否存在员工姓Liu
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("Liu"));
        System.out.println(noneMatch);

        System.out.println("*****************************");
        //findFirst(): 返回流中的第一个元素
        //注意: findFirst()与limit()不一样，findFirst()是终止操作，而limit()是中间操作
        Optional<Employee_Reference> first = employees.stream().findFirst();
        System.out.println(first);

        System.out.println("*****************************");
        //findAny(): 返回当前流中的任意元素
        Optional<Employee_Reference> any = employees.stream().findAny();
        //这里的stream()是Stream里的方法，得到的是一个顺序流，故得到的结果总是第一个元素
        System.out.println(any);
        //可以用parallelSteam()得到一个并行流，这样运行的结果就可能是别的元素了
        Optional<Employee_Reference> any1 = employees.parallelStream().findAny();
        System.out.println(any1);


    }


    @Test
    public void test2() {
        List<Employee_Reference> employees = Employee_Data.getEmployee();
        System.out.println("*****************************");
        //count(): 返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);
        //练习: 返回工资高于5000的员工个数
        long count1 = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count1);
        System.out.println("*****************************");
        //max(Comparator c)       返回流中的最大值
        //练习: 返回最高的工资
        Comparator<Employee_Reference> comparator = new Comparator<>() {
            @Override
            public int compare(Employee_Reference o1, Employee_Reference o2) {
                double o1Salary = o1.getSalary();
                double o2Salary = o2.getSalary();
                return Double.compare(o1Salary, o2Salary);
            }
        };
        Optional<Employee_Reference> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
        //方法2: 只取工资比
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

        System.out.println("*****************************");
        //min(Comparator c)       返回流中的最小值
        //练习: 返回工资最低的员工，这里不要用map
        Optional<Employee_Reference> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println("*****************************");
        //forEach(Consumer c)     内部迭代
        employees.stream().forEach(System.out::println);


    }


    @Test
    public void test3() {

    }
}
