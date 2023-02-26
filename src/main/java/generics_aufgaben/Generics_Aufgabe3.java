package generics_aufgaben;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
1. 泛型在继承方面的体现:
2. 通配符的使用:
 */

//: ; ( )
public class Generics_Aufgabe3 {
    /*
    1. 泛型在继承方面的体现:
        类A是类B的父类，G<A>和G<B>二者不具备子父类关系，而是并列关系
        但是若类A是类B的父类 或A是接口，则A<G>是B<G>的父类
     */
    @Test
    public void test2() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;

        list1 = list2;
    }

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str; //多态的体现: 可以把子类对象赋给父类的引用

        Object[] arr = new Object[10];
        String[] arr1 = new String[10];
        arr = arr1;//多态

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时list1和list2的类型不具备子父类关系
        // list1 = list2; 这样是不对的
    }

    /*
    2. 通配符?的使用:
        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是G<?>
    */
    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

        //print(list1);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)对于List<?>不能向其内部添加数据，除了null之外
        list.add(null);
        //获取(读取) 允许读取，读取的数据类型为Object
        Object obj = list.get(0);
        System.out.println(obj);

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /*
    3. 有限制条件的通配符的使用:
        G<? extends A>可做G<A>和G<B>的父类，其中B是A的子类，即?应<=A类
        G<? super A>可做G<A>和G<B>的父类，其中B是A的父类，即?应>=A类
    */
    @Test
    public void test4() {
        List<? extends Vater> list1 = null;
        List<? super Vater> list2 = null;

        List<Sohn> list3 = null;
        List<Vater> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

    }

}
