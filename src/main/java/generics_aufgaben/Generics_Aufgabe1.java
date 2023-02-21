package generics_aufgaben;

import org.junit.Test;

import java.util.*;

/*
泛型: 是一个标签，是一个表示元素类型的参数
1. 泛型是允许在定义类，接口时通过一个标识表示类中某个属性的类型或某个方法的返回值及参数类型
   此参数类型将在使用时(如继承或实现接口，用此类型声明变量，创建对象时确定（即传入实际的类型参数）
2. 在集合中使用泛型(在jdk5.0时集合接口和集合类都已修改为带泛型的结构)
    i)在实例化集合类时，可指明具体的泛型类型，如String，Integer等
    ii)指明完之后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，
       都指定为实例化的泛型。如add(E e)实例化后为add(Integer e)
    iii)泛型的类型必须是类，不能是基本数据类型，要用基本数据类型时用相应的包装类
    iv)若实例化时没有指定泛型类型，则默认类型为Java.lang.Object

; : ()
 */
public class Generics_Aufgabe1 {
    //用泛型
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---" + value);
        }
    }

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(88);
        list.add(99);
        list.add(65);
        //编译时就进行类型检查，保证数据安全
        //list.add("Tom");

        for (Integer score : list) {
            //问题2 避免强转
            int stuScore = score;
            System.out.println(stuScore);
        }
        System.out.println("%%%%%%%%%%%%%%%%%");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }


    }

    //不用泛型之前
    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        // 存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // 问题1 类型不安全
        // list.add("Tom");

        for (Object score : list) {
            //问题2 强转时可能会出异常 ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }


    }
}
