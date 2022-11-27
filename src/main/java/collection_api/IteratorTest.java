package collection_api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    // Methode 14: iterator() 返回Iterator接口的实例，用于遍历元素
    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new PersonForCollection("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator = collection.iterator();
        //iterator 不是容器，不装信息
        //iterator 首次指向第一个元素的上方
        //每次调用iterator()方法都得到一个全新的迭代器，故不能匿名，一定要定义一个变量

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //iterator.next() 作用1: 指针下移， 作用2: 返回下移后集合位置上的元素
        }
    }

    @Test
    public void test1() {
        //iterator() + remove()
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new PersonForCollection("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if ("Tom".equals(next)) {
                iterator.remove();
            }
        }

        //此时遍历要获取一个新的迭代器，因为上一个迭代器iterator已经指向最后一个元素了
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


    }
}
