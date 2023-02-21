package generics_aufgaben;

import employee.Employee;
import employee.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Generics_EmployeeTest {
    @Test
    public void test1() {
        Employee emp1 = new Employee("Andy", 58, new MyDate(1965, 5, 4));
        Employee emp2 = new Employee("Victor", 43, new MyDate(1980, 5, 4));
        Employee emp3 = new Employee("Tom", 44, new MyDate(1979, 5, 9));
        Employee emp4 = new Employee("Jack", 51, new MyDate(1972, 8, 12));
        Employee emp5 = new Employee("Candy", 58, new MyDate(1965, 12, 4));

        TreeSet<Employee> set = new TreeSet<>();
        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp4);
        set.add(emp5);

        Iterator<Employee> iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            Employee next = iterator1.next();
            System.out.println(next);
        }
    }

    @Test
    public void test2() {
        Employee emp1 = new Employee("Andy", 58, new MyDate(1965, 5, 4));
        Employee emp2 = new Employee("Victor", 43, new MyDate(1980, 5, 4));
        Employee emp3 = new Employee("Tom", 44, new MyDate(1979, 5, 9));
        Employee emp4 = new Employee("Jack", 51, new MyDate(1972, 8, 12));
        Employee emp5 = new Employee("Candy", 58, new MyDate(1965, 12, 4));

        TreeSet<Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {
            //有泛型时
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate date1 = o1.getBirthday();
                MyDate date2 = o2.getBirthday();
                return date1.compareTo(date2);
            }
        });
 /*   没有泛型时
 @Override

            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate date1 = e1.getBirthday();
                    MyDate date2 = e2.getBirthday();

                    //方法1
//                    int diffYear = date1.getYear()- date2.getYear();
//                    if(diffYear!=0)
//                    {
//                        return diffYear;
//                    }
//
//                    int diffMonth = date1.getMonth()- date2.getMonth();
//                    if(diffMonth!=0)
//                    {
//                        return diffMonth;
//                    }
//
//                    return date1.getDay()- date2.getDay();
//                }
//                throw new RuntimeException("wrong input");

                    //方法2
                    return date1.compareTo(date2);

                }
                throw new RuntimeException("wrong input");
            }
        });
*/

        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);
        treeSet.add(emp5);

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next);
        }

    }
}
