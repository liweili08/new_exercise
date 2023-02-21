package map_uebung;

import org.junit.Test;

import java.util.*;

/*
Map Interface:
    具体的实现类: HashMap, LinkedHashMap, TreeMap, Hashtable, Properties

    Map 存储双列（key-value）数据
        具体的实现类: HashMap: 主要实现类，线程不安全，效率高，可存储null的key和value，底层为数组+链表+红黑树
                            子类 LinkedHashMap: 加了一对指针，保证在遍历时可按照添加元素的顺序打印元素
                                                在有频繁遍历时用LinkedHashMap好
                    TreeMap: 可按照添加的key-value进行排序，是按key的自然排序或定制排序排的，底层为红黑树
                    Hashtable: 古老实现类，线程安全，效率低，不可存储null的key和value
                              子类 Properties: 用来处理配置文件，key和value都是String型
HashMap: key无序，不可重复，可用Set来存，value无序，可重复，用Collection存
         把key和value组合成一个Entry，Entry时无序，不可重复的，因为key不可重复
         故而Entry使用Set来存的
         key若是HashSet存的，其所在的类要重写equals和hashCode方法
         value所在的类要重写equals方法
HashMap底层实现原理:
    1. Map map = new HashMap() 实例化后底层创建了长为16的一维数组 Entry[] table
    2. map.put(key, value) 调用key所在类的hashCode方法计算key的hash值，经过计算之后
       得到其在Entry数组中的位置:
       若此位置上数据为空，则(key, value)添加到Entry中------情况1
       若此位置上数据不为空，即此位置上有1个或多个数据(以链表形式)
        则比较key和已经存在的一个或多个数据的hash值，
            若都不相同，则(key, value)添加到Entry中------情况2
            若有相同，即存在(key2, value2)，key2与key1的hash值相同，则用key所在类的equals方法比较
                若equals返回false，则(key, value)添加到Entry中------情况3
                若返回true， 则用key替换key2 (此时的put还有修改的效果)
     情况2和情况3中用链表方式储存
     添加过程中的扩容方式:扩容为2倍并把原map拷贝过来
     JDK8中当数组的某个索引位置上的元素以链表形式存在的数据个数大于8且当前数组长度大于64时，
     此索引位置上的所有数据改为红黑树储存


Map接口中的方法:
    : ;

 */
public class Map_Aufgaben {
    /*
    Map接口中的方法:
    Object put(Object key, Objekt value):把指定的键值对添加或修改到当前map中
    void putAll(Map m):把m中的所有键值对存到当前map中
    Object remove(Object key):移除指定key的键值对并返回value
    void clear():清空当前map中的所有数据，与map=null不同，map还在，size变为0
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        Map map2 = new HashMap();
        map.put(null, 123);
        map.put(null, null);
        map.put("AA", 123);
        map.put("AA", 22);
        map.put("BB", 34);
        map2.put("CC", 34);
        map2.put("DD", 22);
        map.putAll(map2);
        Object o = map.remove("CC");
        map2.clear();

        System.out.println(map);
        System.out.println(o);
        System.out.println(map2.size());
        System.out.println(map2);

        //Map map1= new Hashtable();
        //map1.put(null,123);
    }

    /*
   Map接口中的方法:
   Object get(Object key):获取指定的key对应的value
   boolean containsKey(Object key):判断是否有指定的key
   boolean containsValue(Object value):判断是否有指定的value，找到一个就不继续找了
   int size():返回map中键值对的个数
   boolean isEmpty():判断map是否为空
   boolean equals():判断map
   void clear(Object obj):判断当前map是否与obj相等
    */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 56);
        map.put(45, 123);

        System.out.println(map.get("AA"));
        System.out.println(map.containsKey("DD"));
        System.out.println(map.containsValue(123));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }

    /*
Map接口中的方法:
Set keySet():返回所有key构成的Set
Collection values(): 返回所有value构成的Collection
Set entrySet(): 返回所有Entry构成的Set
*/
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 56);
        map.put(45, 1232);

        Set keySet = map.keySet();
        Iterator iteratorKey = keySet.iterator();
        while (iteratorKey.hasNext()) {
            System.out.println(iteratorKey.next());
        }
        System.out.println("**************************");
        for (Object str : keySet) {
            System.out.println(str);
        }
        System.out.println("**************************");
        Collection values = map.values();
        Iterator iteratorValue = values.iterator();
        while (iteratorValue.hasNext()) {
            System.out.println(iteratorValue.next());
        }
        System.out.println("**************************");
        Set entrySet = map.entrySet();
        Iterator iteratorEntry = entrySet.iterator();
        while (iteratorEntry.hasNext()) {
            System.out.println(iteratorEntry.next());
        }
    }
}
