package collection_set;

import collection_api.PersonForCollection;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Collection Interface hat zwei wichtige Sub-Interfaces:
    1) List Interface: (有序，可重复)
        具体的实现类: ArrayList, LinkedList, Vector
    2) Set Interface: (无序，不可重复，类似与Menge)
        具体的实现类: HashSet: 是Set接口的主要实现类，线程不安全，可存储Null值
                        LinkedHashSet: 是HashSet的子类，加了链表，使得遍历其内部元素时可按照添加的顺序遍历，看似有序
                    TreeSet: 底层时红黑树，其元素都是某个类new出来的对象，且可以按照添加对象的指定属性进行排序

       注: Set接口中没有额外定义新的方法，都是用的Collection中声明过的方法

无序性: 不等于随机性，存储的数据在底层数组中不是按照索引顺序添加，而是根据数据的Hash值
不可重复性: 保证添加的元素按照equals方法判断时不能返回true，即相同的元素只能添加一次

以HashSet为例，添加元素的过程
向HashSet中添加元素a，首先调用元素a所在类的hashCode方法，计算元素a的hash值。此hash值接着通过某种算法计算出在HashSet底层数组
中的存放位置，即索引位置，判断数组此位置上是否已经有元素
    若此位置上没有元素，则元素a添加成功          --->添加成功情况1
    若此位置上已经有元素b或是以链表形式存在的多个元素，则比较元素a与元素b的hash值:
        若hash值不同，则a添加成功             --->添加成功情况2
        若hash值相同，则要进一步调用元素a所在类的equals方法:
            equals返回true，元素a添加失败
            equals返回false，元素a添加成功    --->添加成功情况3
对于添加成功的2和3来说, 元素a与已经存在指定索引位置上的数据以链表的方式存储
HashSet底层是数组 + 链表
要求: 向Set中添加的数据，其所在类要重写hashCode()和equals()方法
     重写的hashCode()和equals()方法尽可能保持一致性，即相等的对象必须有相等的hash值

 */
public class Set_Aufgaben {
    @Test
    public void test() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new PersonForCollection("Tom", 12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        HashSet set = new HashSet();
        PersonForCollection p1 = new PersonForCollection("AA", 11);
        PersonForCollection p2 = new PersonForCollection("BB", 12);

        set.add(p1);
        set.add(p2);

        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);

        set.add(new PersonForCollection("CC", 11));
        System.out.println(set);
        set.add(new PersonForCollection("AA", 11));
        System.out.println(set);

//        Iterator iterator = set.iterator();
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
    }
}
