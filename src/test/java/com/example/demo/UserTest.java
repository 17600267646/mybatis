package com.example.demo;


import model.Person;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserTest {

	SqlSession sqlSession ;
	@Test
	public void insertPerson(){
		sqlSession = MybatisUtil.getSqlSession();
		Person person = new Person();
		person.setId(7);
		person.setAge(200);
		person.setUserName("xiagn");
		person.setMobilePhone("14");
		try{
			sqlSession.insert("insertPerson",person);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MybatisUtil.closeSession(sqlSession);
		}
		System.out.println(person.getId()+"              "+person.getAge());
	}

	@Test
	public void queryById(){
		sqlSession = MybatisUtil.getSqlSession();
		int id = 2;
		try{
			Person person = sqlSession.selectOne("queryById",id);

			sqlSession.commit();
			System.out.println(person.getUserName());
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MybatisUtil.closeSession(sqlSession);
		}

	}
	@Test
	public  void uopdatePerson(){
		sqlSession=MybatisUtil.getSqlSession();
		Person person=new Person(5,"小红",25,"25");

		try {
			sqlSession.update("updatePerson",person);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			MybatisUtil.closeSession(sqlSession);
		}
	}
	@Test
	public  void deleteById(){
		sqlSession=MybatisUtil.getSqlSession();
		Person person=new Person();
		person.setId(2);
		try {
			sqlSession.delete("deleteById",person);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();;
		}finally {
			MybatisUtil.closeSession(sqlSession);
		}
	}
}
