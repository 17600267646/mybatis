package service;

import model.Person;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/10/6 0006.
 */
public class PerTest {

    public static void main(String[] args) {
        // insertPerson();
        //   deleteByd();
        //queryById();
       selectAllUser();
    }

    private static void selectAllUser() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        try {
            List<Person> list= personMapper.selectAllPerson();
            System.out.println(list.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    private static void queryById() {
        SqlSession session = MybatisUtil.getSqlSession();
        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        try {
           Person person= personMapper.queryById(3);
            System.out.println(person.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

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


    /**
     * 删除用户
     */
        /*private static void deleteUser(){
            SqlSession session=DBTools.getSession();
            UserMapper mapper=session.getMapper(UserMapper.class);
            try {
                mapper.deleteUser(1);
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
            }
        }


        *//**
     * 根据id查询用户
     *//*
        private static void selectUserById(){
            SqlSession session=DBTools.getSession();
            UserMapper mapper=session.getMapper(UserMapper.class);
            try {
                UserBean user=    mapper.selectUserById(2);
                System.out.println(user.toString());

                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
            }
        }

        *//**
     * 查询所有的用户
     *//*
        private static void selectAllUser(){
            SqlSession session=DBTools.getSession();
            UserMapper mapper=session.getMapper(UserMapper.class);
            try {
                List<UserBean> user=mapper.selectAllUser();
                System.out.println(user.toString());
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
            }
        }


    }*/

}
