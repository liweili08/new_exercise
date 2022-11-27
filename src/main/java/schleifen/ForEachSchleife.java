package schleifen;

import collection_api.PersonForCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachSchleife {
    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new PersonForCollection("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        for (Object obj : collection) {
            System.out.println(obj);
            //本质用了迭代器
        }
    }

    @Test
    public void test1() {
        //Array:
        String[] arr = new String[]{"AA", "BB"};
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 3;

        for (String str : arr) {
            System.out.println(str);
        }

        for (int num : array) {
            num++;
            System.out.println(num);
        }
    }

    @Test
    public void test2()
    {
        String[] arr =new String[]{"MM","MM","MM"};
//        for(int i=0;i<arr.length;i++)
//        {
//            arr[i]="GG";
//        }

        for(String str:arr)
        {
            str="GG";
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
            //用普通for循环会把MM都改成GG， 因为是直接用GG赋值给本身的元素arr[i]
            //用增强for循环不会把MM改成GG， 因为str是一个新的变量，是把arr中的元素取出来赋给str，然后把str的值改了，
            //                          但arr中元素本身没有改变
        }
    }
}
