package generics_aufgaben;

//自定义的泛型类
//定义构造器时不加<>，但在实例化时要加<>
//实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致
//泛型不同的引用不能相互赋值
//静态方法中不能用类的泛型
//异常类不能声明为泛型类

public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
    }

    ;

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

    //静态方法中不能用类的泛型，因为泛型是在实例化的时候指定的，而static方法要早于对象的创建，
    //相当于类的泛型还没有指定，就要在方法中使用了，就会报错
//    public static void show(T orderT)
//    {
//        System.out.println(orderT);
//    }
}
