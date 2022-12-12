package collection_list;

import collection_api.PersonForCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.valueOf;

/*
Collection Interface hat zwei wichtige Sub-Interfaces:
    1) List Interface: (有序，可重复)
        具体的实现类: ArrayList: 主要实现类，效率高，但线程不安全。底层使用Object[]存储
                    LinkedList: 底层使用双向链表存储，对于频繁的插入，删除操作时用此类比ArrayList效率高
                                找指定位置的元素没有ArrayList快，因为要从第一个元素开始一个一个找下去，
                                而ArrayList直接用脚标即可
                    Vector: 古老实现类，比List接口出现还早，线程安全但效率低，底层使用Object[]存储
        三个类的相同点: 都是List接口的实现类，存储数据的特点都相同: 有序，可重复

        ArrayList源码分析:
        jdk7时:
        ArrayList list = new ArrayList(); //底层创建一个长度为10的Object[]数组，数组名为elementData
        list.add(123); //elementData[0]=new Integer(123);
        ...
        list.add(11); //若此次添加导致elementData数组容量不够，则要扩容， 默认情况下，扩容为原来的1.5倍，
                        同时还要把原有数组复制到新数组中

        结论: 在开发中一般可知list的大致长度，建议用带参构造器 ArrayList list = new ArrayList(int capacity);
              可减少扩容次数

        jdk8时:
        ArrayList list = new ArrayList(); //底层Object[]数组elementData= {}，长度不是10
        list.add(123); //第一次用add时，才创建长度是10的数组， 并将123加到elementData[0]上;
        后续操作不变

         LinkedList源码分析: 数据存储的基本单位为node，add方法添的核心数据为E item，还有前一个Node prev和下一个Node next


    2) Set Interface: (无序，不可重复)
        具体的实现类: HashSet, LinkedHashSet, TreeSet
 */
public class List_Aufgaben {
    @Test
    public void test()
    {
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new PersonForCollection("Tom",12));
        list.add(456);
        System.out.println(list);

        //Collection中的15个方法依然可用
        //因为ArrayList是有序的，就有了索引的方法
        //Methode 1: add(int index, Object obj)在index位置插入obj元素
        list.add(1,"BB");
        System.out.println(list);

        //Methode 2: addAll(int index, Collection c)在index位置插入collection c的所有元素
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1); //不写index默认加到最后
        System.out.println(list);

        //Methode 3: get(int index) 获取指定位置的元素
        System.out.println(list.get(0));

        //Methode 4: indexOf(Object obj) 返回obj在当前集合中首次出现的位置，若list里没有obj则返回-1
        System.out.println(list.indexOf(4567));

        //Methode 5: lastIndexOf(Object obj) 返回obj在当前集合中末次出现的位置，若list里没有obj则返回-1
        System.out.println(list.lastIndexOf(4567));

        //Methode 6: remove(int index) 删除指定位置上的元素，并返回此元素
        //           是collection中remove(Object obj)方法的重载(同名但形参列表不同)
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Methode 7: set(int index, Object obj) 设置指定位置的元素为obj
        list.set(1,"CC");
        System.out.println(list);

        //Methode 8: subList(int fromIndex, in toIndex) 返回从fromIndex到toIndex的左闭右开的子集
        List subList = list.subList(2, 4);
        System.out.println(subList);

        //常用方法:
        // 增: add(Object obj),
        // 删: remove(Object obj), remove(int index)
        // 改: set(int index, Object obj)
        // 查: get(int index)
        // 插: add(int index, Object obj)
        // 长度: size()
        // 遍历: iterator, for each, for

    }

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        //list.remove(2);//2是int型，不装箱，自动选择为index
        //list.remove(new Integer(2));
        list.remove(valueOf(2));
    }

}
