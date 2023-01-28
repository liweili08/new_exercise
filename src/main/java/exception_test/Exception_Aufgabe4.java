package exception_test;

/*
可在 Run edit Configurations program arguments里添加
数组
 */

public class Exception_Aufgabe4 {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int result = ecm(i, j);
            System.out.println(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (EcDef e) {
            e.printStackTrace();
        }

    }

    public static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0) {
            throw new EcDef("分子或分母为负数");
        }
        return i / j;
    }
}

