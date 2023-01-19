package collection_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//在List内去掉重复数字: 用Set的特性
public class Set_Aufgabe2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(4));

        List newList = duplicateList(list);

        Iterator iterator = newList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
}
