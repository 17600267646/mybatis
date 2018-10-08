package service;

import model.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/6 0006.
 */
public interface PersonMapper {
    //接口文件的名称 必须和mapper.xml中对应sql的id一致
    public  int insertPerson(Person person) throws Exception;
    public  int deleteById(Person person) throws Exception;
    public  Person queryById(int id ) throws Exception;
    public List<Person> selectAllPerson() throws  Exception;
    public int batchSave(List<Person> list) throws  Exception;
    public  int batchDelete(List<Person> list) throws  Exception;
    public int batchUpdate(List<Person> list);
}
