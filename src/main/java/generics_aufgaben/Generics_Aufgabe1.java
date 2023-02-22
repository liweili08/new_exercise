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

3. 泛型类可能有多个，一起放在尖括号中，用逗号隔开 <E1, E2, E3>
4. 空参构造器不用加尖括号，但在实例化是要加
5. 泛型不同的引用不能相互赋值
6. 若泛型结构是一个接口或抽象类，则不可创建泛型结构的对象，因为接口和抽象类不能实例化
7. 静态方法中不能用类的泛型，因为泛型是在实例化的时候指定的，而static方法要早于对象的创建，
   相当于类的泛型还没有指定，就要在方法中使用了，就会报错
8. 异常类不能声明为泛型类，也不能在catch处抓泛型类T，因为若T不是异常类，编译会出错
9. 父类有泛型，子类可以保留泛型也可以指定泛型类型:
     i) 子类保留父类泛型: 可全部保留，也可部分保留
     ii) 子类不保留父类泛型: 可以指定具体类型，也可以没有类型，即变成Object类
     iii) 子类还可以增加自己的泛型
     z.B. class Father<T1, T2>{}
          擦除父类泛型
          class Son1 extends Father{} (擦除泛型，等价于 class Son1 extends Father<Object,Object>{})
          指定具体类型
          class Son2 extends Father<Integer, String>{}
          保留全部泛型
          class Son3<T1,T2> extends Father<T1,T2>{}
          保留部分泛型
          class Son4<T2> extends Father<Integer,T2>{}
          增加自己的泛型+擦除父类泛型
          class Son5<A,B> extends Father{} 等价于 class Son1<A,B> extends Father<Object,Object>{}
          增加自己的泛型+指定具体类型
          class Son6<A,B> extends Father<Integer, String>{}
          增加自己的泛型+保留全部泛型
          class Son7<A,B,T1,T2> extends Father<T1,T2>{}
          增加自己的泛型+保留部分泛型
          class Son8<A,B,T2> extends Father<Integer,T2>{}

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
