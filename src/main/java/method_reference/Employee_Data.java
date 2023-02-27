package method_reference;

import java.util.ArrayList;
import java.util.List;

public class Employee_Data {
    public static List<Employee_Reference> getEmployee() {
        List<Employee_Reference> list = new ArrayList<>();
        list.add(new Employee_Reference(1001, "QQ", 34, 6000.38));
        list.add(new Employee_Reference(1002, "TB", 12, 9876.12));
        list.add(new Employee_Reference(1003, "JD", 33, 3000.82));
        list.add(new Employee_Reference(1004, "XM", 26, 7657.37));
        list.add(new Employee_Reference(1005, "BD", 65, 5555.32));
        list.add(new Employee_Reference(1006, "MS", 42, 9500.43));
        list.add(new Employee_Reference(1007, "HW", 26, 4333.32));
        list.add(new Employee_Reference(1008, "FB", 35, 2500.32));

        return list;

    }
}
