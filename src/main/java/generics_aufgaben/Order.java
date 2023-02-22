package generics_aufgaben;

//自定义的泛型类
//定义构造器时不加<T>，但在实例化时要加<>
//实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致
//泛型不同的引用不能相互赋值
//静态方法中不能用类的泛型
//异常类不能声明为泛型类

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    //空参构造器不用加尖括号，但在实例化是要加
    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    //下面3个方法都不是泛型方法(不是说方法里用了泛型就叫泛型方法)
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法: 在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法可以是static的，因为泛型参数是在调用方法时确定的，并非在实例化类时确定


    //举例: 如果没有<E>，Java会以为有个类叫做E，加上<E>以后Java就知道这里是表示泛型，
    //List<E>是返回值，E[]是数组但还不确定是什么类型
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

    //静态方法中不能用类的泛型，因为泛型是在实例化的时候指定的，而static方法要早于对象的创建，
    //相当于类的泛型还没有指定，就要在方法中使用了，就会报错
//    public static void show(T orderT)
//    {
//        System.out.println(orderT);
//    }
}
