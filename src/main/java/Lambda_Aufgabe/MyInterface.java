package Lambda_Aufgabe;


@FunctionalInterface
//不加@FunctionalInterface也是函数式接口，
//加上注解以后会自动校验，保证只声明一个抽象方法，不加注解的话可以声明很多方法
public interface MyInterface {
    void method1();

    //void method();
}
