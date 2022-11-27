package collection_api;

import org.junit.Test;

import java.util.*;

public class Collection_Api {
    // 向Collection接口的实现类中添加数据obj时，要求obj所在类要重写equals方法
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        // Methode 1: add(E e) (füge e in coll hinzu)
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        // Methode 2: size() (die Länge der Liste coll)
        System.out.println(coll.size());

        // Methode 3: addAll(Collection c) (füge alle Elemente von c in der jetziger Liste hinzu)
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");

        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        // Methode 4: clear() (lösche alle Elemente in der jeztiger Liste.)
        // Achtung: Das Object coll existiert noch. coll != null
        coll.clear();

        // Methode 5: isEmpty() (Unterscheide, ob die jetzige Liste keine Elemente besitzt.)
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test2()
    {
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new PersonForCollection("Jerry", 20));

        // Methode 6: contains(Object o)(判断时调用所在类的equals方法对list里的每个元素依次比较，找到一个以后就返回true并停止)
        boolean cont = collection.contains(123);
        System.out.println(cont);//true
        System.out.println(collection.contains(new String("Tom")));//true
        //Achtung: die zwei "Tom" sind unterschiedliche Objekte. Das Ergebnis ist true, d.h. die Methode contains
        //vergleicht den Inhalt(statt die Adressen) mit der equals Methode
        System.out.println(collection.contains(new PersonForCollection("Jerry", 20)));//false,
        //Da in der Klasse PersonForCollection ist die equals Methode noch nicht override

        // Methode 7: containsAll(Collection c) p判断c中元素是否全部存在于当前list中
        Collection collection1= Arrays.asList(123,4567);
        System.out.println(collection.containsAll(collection1));

        // Methode 8: remove(Object obj) 找到obj并移除后返回true， 若没有找到obj则返回false <也调用了equals方法!>
        collection.remove(123);
        System.out.println(collection);

        collection.remove(new PersonForCollection("Jerry", 20));
        System.out.println(collection);

        // Methode 9: removeAll(Collection c) 从当前list中移除交集即求差集 <也调用了equals方法!>
        Collection collection2=Arrays.asList(false,4567);
        collection.removeAll(collection2);
        System.out.println(collection);
    }

    @Test
    public void test3()
    {
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new PersonForCollection("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        // Methode 10: retainAll(Collection c) 求当前list与c的交集
        Collection coll1=Arrays.asList(123,456,789);
        collection.retainAll(coll1);
        System.out.println(collection);

        // Methode 11: equals(Object obj) 只有obj也为list且他们的元素都相等才返回true，
        // 对于ArrayList顺序不同也会返回false，若是set则顺序不同也会返回true
        Collection collection2=new ArrayList();
        collection2.add(123);
        collection2.add(456);

        System.out.println(collection.equals(collection2));

        // Methode 12: hashCode()
        System.out.println(collection.hashCode());

        // Methode 13: toArray() 把当前的collection变成数组
        //Arrays.asList(x,y,z) 把数组(x，y，z)转换为list
        Object[] arr = collection.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
    }

}
