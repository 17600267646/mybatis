package service;

import model.Person;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/6 0006.
 */
public class PerTest {

    public static void main(String[] args) {
        // insertPerson();
        //   deleteByd();
        //queryById();
        // selectAllUser();
        //batchSave();
        //batchDelete();
        batchUpdate();
    }

    /*
    * 批量更新用户
    * */
    private static void batchUpdate() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.setId(1111 + i);
            person.setAge(99);
            person.setMobilePhone("99");
            person.setUserName("工作");
            list.add(person);
        }

        try {
            int c = personMapper.batchUpdate(list);
            System.out.println("数量为" + c);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }


    /*
    * 批量删除用户
    * */
    private static void batchDelete() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        List<Person> list = new ArrayList<>();
        Person p1 = new Person();
        p1.setId(25);
        Person p2 = new Person();
        p2.setId(26);
        Person p3 = new Person();
        p3.setId(27);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        try {
            int c = personMapper.batchDelete(list);
            System.out.println("删除数量为" + c);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /*
    * 批量插入用户
    * */
    private static void batchSave() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.setId(1111 + i);
            person.setAge(12);
            person.setMobilePhone("110");
            person.setUserName("小明");
            list.add(person);
        }
        try {
            personMapper.batchSave(list);
            System.out.println(list.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /*查询所有用户*/
    private static void selectAllUser() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        try {
            List<Person> list = personMapper.selectAllPerson();
            System.out.println(list.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /*根据id查找某个用户*/
    private static void queryById() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        try {
            Person person = personMapper.queryById(3);
            System.out.println(person.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    /*删除用户*/
    private static void deleteByd() {

        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setId(100);
        try {
            personMapper.deleteById(person);
            System.out.println(person.toString() + "++++++++++++");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }

    }


    /**
     * 新增用户
     */
    private static void insertPerson() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        Person person = new Person(1, "如", 13, "1314");
        try {
            mapper.insertPerson(person);
            System.out.println(person.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }


}
