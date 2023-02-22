package generics_aufgaben;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Generics_Aufgabe2 {
    @Test
    public void test1() {
        //使用泛型类时若没有指明类的泛型，则默认泛型为Object
        //若定义时是有泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        //使用泛型类时指明类的泛型
        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");
        order1.setOrderT("AA: hello");
        System.out.println(order1.toString());
    }

    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        //由于子类在继承父类时已经指明了泛型的类型，则实例化子类对象时不需要指明泛型
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("suborder2...");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
        //list1 = list2;

    }

    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] array = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型，这里用了Integer，可以换成其他的类
        List<Integer> list = order.copyFromArrayToList(array);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
