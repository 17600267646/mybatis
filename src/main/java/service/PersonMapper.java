package service;

import model.Person;

import java.util.List;

/**
 * Created by Administrator on 2018/10/6 0006.
 */
public interface PersonMapper {
    //接口文件的名称 必须和mapper.xml中对应sql的id一致
    public  int insertPerson(Person person) throws Exception;
    public  int deleteById(Person person) throws Exception;
    public  Person queryById(int id ) throws Exception;
    public List<Person> selectAllPerson() throws  Exception;
}
