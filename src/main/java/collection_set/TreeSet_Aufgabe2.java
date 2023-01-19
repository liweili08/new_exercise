package collection_set;

import collection_api.PersonForCollection;
import employee.Employee;
import employee.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_Aufgabe2 {
    @Test
    public void test4() {
        Comparator comparator = new Comparator() {
            //按age从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof PersonForCollection && o2 instanceof PersonForCollection) {
                    PersonForCollection p1 = (PersonForCollection) o1;
                    PersonForCollection p2 = (PersonForCollection) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("wrong input");
                }
            }
        };

        TreeSet treeSet = new TreeSet(comparator);

        treeSet.add(new PersonForCollection("Tom", 12));
        treeSet.add(new PersonForCollection("Jerry", 32));
        treeSet.add(new PersonForCollection("Jim", 2));
        treeSet.add(new PersonForCollection("Mike", 65));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test5() {
        Employee emp1 = new Employee("Andy", 58, new MyDate(1965, 5, 4));
        Employee emp2 = new Employee("Victor", 43, new MyDate(1980, 5, 4));
        Employee emp3 = new Employee("Tom", 44, new MyDate(1979, 5, 9));
        Employee emp4 = new Employee("Jack", 51, new MyDate(1972, 8, 12));
        Employee emp5 = new Employee("Candy", 58, new MyDate(1965, 12, 4));

        TreeSet treeSet = new TreeSet();
        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);
        treeSet.add(emp5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test6() {
        Employee emp1 = new Employee("Andy", 58, new MyDate(1965, 5, 4));
        Employee emp2 = new Employee("Victor", 43, new MyDate(1980, 5, 4));
        Employee emp3 = new Employee("Tom", 44, new MyDate(1979, 5, 9));
        Employee emp4 = new Employee("Jack", 51, new MyDate(1972, 8, 12));
        Employee emp5 = new Employee("Candy", 58, new MyDate(1965, 12, 4));

        TreeSet treeSet = new TreeSet(new Comparator() {
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
        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);
        treeSet.add(emp5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
