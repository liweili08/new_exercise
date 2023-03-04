package optional_test;

import org.junit.Test;

import java.util.Optional;

/*
Optional<T>类(java.util.Optional)是一个容器类。它可以保存类型为T的值，代表这个值存在，
或者保存null，表示这个值不存在。原来是用null表示一个值不存在，现在用Optional可以更好的表达
职工概念且可以避免空指针异常

Optional类在Javadoc中的描述如下: 这是一个可以为null的容器对象。
若值存在则isPresent()方法返回true，调用get()方法会返回该对象

Optional类中的方法:
1. 创建Optional类对象的方法
   -Optional.of(T t): 创建一个Optional实例，t必须非空
   -Optional.empty(): 创建一个空的Optional实例
   -Optional.ofNullable(T t): 创建一个Optional实例，t可以为空

2. 判断Optional容器中是否包含对象
    -boolean isPresent(): 判断是否包含对象
    -void ifPresent(Consumer<? super T> consumer): 如果有值，执行Consumer接口的
                                                   实现代码并把值作为参数传给它
3. 获取Optional容器的对象
    -T get(): 若调用对象包含值，返回该值，否则抛异常
    -T orElse(T other): 若有值则将其返回，否则返回指定的other对象
    -T orElseGet(Supplier<? extends T> other): 若有值则将其返回，否则返回由Supplier
                                               接口实现提供的对象
    -T orElseThrow(Supplier<? extends X> exceptionSupplier): 若有值则将其返回，否则
                                               返回抛出用Supplier接口实现提供的异常

; : (): <> //
 */
public class Optional_Aufgabe1 {
    @Test
    public void test1() {
        Car car = new Car();
        //Car car = null;  car为null时会出现NullPointerException空指针异常
        Optional<Car> optionalCar = Optional.of(car);
    }

    @Test
    public void test2() {
        //Car car = new Car();
        Car car = null; // car为null时不会有异常
        Optional<Car> optionalCar = Optional.ofNullable(car);
        System.out.println(optionalCar);
        Car orElseCar = optionalCar.orElse(new Car("VW"));
        System.out.println(orElseCar);

    }

    public String getCarName(Boy boy) {
        return boy.getCar().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        //String carName = getCarName(boy);  Cannot invoke "optional_test.Car.getName()" because the return value of "optional_test.Boy.getCar()" is null
        String carName1 = getCarName1(boy);
        System.out.println(carName1);
    }

    public String getCarName1(Boy boy) {
        if (boy != null) {
            Car car = boy.getCar();
            if (car != null) {
                return car.getName();
            }
        }
        return null;
    }

    public String getCarName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //orElseBoy 一定非空
        Boy orElseBoy = boyOptional.orElse(new Boy(new Car("BMW")));
        Car car = orElseBoy.getCar();
        Optional<Car> optionalCar = Optional.ofNullable(car);
        //orElseCar 一定非空
        Car orElseCar = optionalCar.orElse(new Car("Toyota"));
        return orElseCar.getName();
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        String carName = getCarName2(boy);
        System.out.println(carName);// Toyota
        System.out.println("*****************");
        Boy boyNull = null;
        System.out.println(getCarName2(boyNull));
        System.out.println("*****************");
        Boy boyMitCar = new Boy(new Car("Honda"));
        System.out.println(getCarName2(boyMitCar));
    }
}
