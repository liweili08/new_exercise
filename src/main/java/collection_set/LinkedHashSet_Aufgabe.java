package collection_set;

import collection_api.PersonForCollection;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSet_Aufgabe {
    //LinkedHashSet的使用:
    //是HashSet的子类，在添加数据的同时还加了两个引用来记录前，后的数据。对于频繁的遍历操作，用LinkedHashSet效率更高
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
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
}
