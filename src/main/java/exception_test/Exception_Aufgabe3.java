package exception_test;

import java.util.Scanner;

public class Exception_Aufgabe3 {
    public static void main(String[] args) {
        int[] array = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("给出除数");
        array[0] = scanner.nextInt();
        System.out.println("给出被除数");
        array[1] = scanner.nextInt();
        //System.out.println(array[0] + "and" + array[1]);

        try {
            //Exception_Aufgabe3 test= new Exception_Aufgabe3();
            //float result = test.divide(array);
            //或者把divide改为静态方法
            float result = divide(array);
            System.out.println(result);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NegativeException e) {
            e.printStackTrace();
        }
    }

    public static float divide(int[] array) {
        if (array[0] < 0 || array[1] < 0) {
            throw new NegativeException("不能有负数");
        } else if (array[0] != 0) {
            return (float) array[1] / array[0];
        } else
            throw new ArithmeticException("除数不能为零");
    }
}
