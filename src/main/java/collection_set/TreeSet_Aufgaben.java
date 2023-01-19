package collection_set;

import collection_api.PersonForCollection;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_Aufgaben {
    /*
    TreeSet使用:
        1. 向TreeSet中添加的数据要求是相同类的对象，添加不同类的对象时会出现ClassCastException
        2. 输出集合中元素是按照一定顺序排的(Integer和String都是从小到大排)
        3. 其余的类需要给出排序方式(2种:自然排序和定制排序)
            i) 自然排序: 添加的数据所在类要实现Comparable接口并重写其compareTo方法。
                        自然排序中比较2个对象是否相同的标准为: compareTo方法返回0，不是equals方法
            ii)定制排序: 添加的数据所在类要实现Comparator接口
                        定制排序中比较2个对象是否相同的标准为: compare方法返回0，不是equals方法

    */

    @Test
    public void test3() {
        TreeSet treeSet = new TreeSet();
        //treeSet.add(456);
        //treeSet.add(123);
        //treeSet.add(-34);
        //treeSet.add(3);

        treeSet.add(new PersonForCollection("Tom", 12));
        treeSet.add(new PersonForCollection("Jerry", 32));
        treeSet.add(new PersonForCollection("Jim", 2));
        treeSet.add(new PersonForCollection("Mike", 65));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
