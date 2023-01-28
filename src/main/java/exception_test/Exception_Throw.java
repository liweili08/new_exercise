package exception_test;

/*
手动生成异常并throw出
:  () ;
 */
public class Exception_Throw {
    public static void main(String[] args) {
        try {
            ExceptionStudent stu = new ExceptionStudent();
            stu.regist(-1001);
            System.out.println(stu);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}

class ExceptionStudent {
    private int id;

    @Override
    public String toString() {
        return "ExceptionStudent{" +
                "id=" + id +
                '}';
    }

    public void regist(int id) throws MyException {
        if (id > 0) {
            this.id = id;
        } else {
            //System.out.println("wrong input!");
            //手动生成异常，RuntimeException可以不处理
            //throw new RuntimeException("wrong input!");
            //可以换成Exception,此时就需要处理异常了
            //throw new Exception("wrong input!");
            //可以throw自定义的Exception
            throw new MyException("my exception: wrong input");
        }

    }
}
