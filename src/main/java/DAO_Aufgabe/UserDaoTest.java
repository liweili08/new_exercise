package DAO_Aufgabe;

import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        DAO<UserDao> dao = new DAO<>();
        dao.save("001", new UserDao(1, 20, "Tom"));
        dao.save("002", new UserDao(2, 30, "Jerry"));
        List<UserDao> userList = dao.list();
        System.out.println(userList);
        System.out.println("%%%%%%%%%%%%%%%");
        System.out.println(dao.get("001"));
        System.out.println("%%%%%%%%%%%%%%%");
        dao.update("001", new UserDao(1, 22, "Jack"));
        List<UserDao> userList2 = dao.list();
        System.out.println(userList2);
        System.out.println("%%%%%%%%%%%%%%%");
        dao.delete("001");
        List<UserDao> userList3 = dao.list();
        System.out.println(userList3);
    }
}
