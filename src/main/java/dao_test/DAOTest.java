package dao_test;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Generic_Student());
        List<Generic_Student> students = studentDAO.getForList(4);
    }


}
