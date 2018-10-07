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
    /*查询所有用户*/
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
    /*根据id查找摸个用户*/
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
