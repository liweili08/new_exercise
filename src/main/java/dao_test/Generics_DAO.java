package dao_test;
/*
DAO: data(base) access object
 */

//: ; ( )

import java.util.List;

public class Generics_DAO<T> {
    //添加一条记录
    public void add(T t) {
    }

    //删除一条记录
    public void remove(int index) {
    }

    //修改一条记录
    public void update(int index) {
    }

    //查询一条记录
    public T get(int index) {
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index) {
        return null;
    }

    //泛型方法
    //举例: 获取表中一共有多少条记录(则E应用Long，因为Integer可能不够)
    //     获取最大的员工入职时间(则E应用Date)
    public <E> E getValue() {
        return null;
    }
}
