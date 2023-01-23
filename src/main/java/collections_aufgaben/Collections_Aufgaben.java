package collections_aufgaben;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Collections: 工具类，操作Collection和Map
reverse(List list): 反转list中的元素
shuffle(List list): 对list的元素随机排序
sort(List list): 按照元素的自然顺序对list的元素做升序排序
sort(List list, Comparator): 按指定Comparator对list的元素做排序
swap(List, int i, int j): 将指定list集合中的i处元素和j处元素交换

Object max(Collection): 按照元素的自然顺序返回指定集合中的最大元素
Object max(Collection, Comparator):按照指定Comparator返回指定集合中的最大元素
Object min(Collection):
Object min(Collection, Comparator):
int frequency(Collection,Object): 返回指定集合中指定元素的出现次数
void copy(List dest, List src): 把src的元素复制到dest中
boolean replaceAll(List list, Object oldVal, Object newVal): 替换
 */
public class Collections_Aufgaben {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

//        System.out.println(list);
//        Collections.reverse(list); //reverse方法是void，说明list本身被改了
//        System.out.println(list);
//        Collections.shuffle(list);
//        System.out.println(list);

//        Collections.sort(list);
//        System.out.println(list);
//        Collections.swap(list,1,2);
//        System.out.println(list);

// Exception: java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
//        System.out.println(dest);
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest, list);
        System.out.println(dest);
        // list1是线程安全的
        List list1 = Collections.synchronizedList(list);

    }
}
