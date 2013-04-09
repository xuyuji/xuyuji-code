package org.xuyuji.DaoDemo.jdbctemplate;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xuyuji.DaoDemo.dao.PersonDao;
import org.xuyuji.DaoDemo.entity.Person;

public class PersonDaoImplTest extends TestCase {
	public void testQueryAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/xuyuji/DaoDemo/jdbctemplate/person.xml");
		PersonDao dao = context.getBean("personDaoImpl", PersonDaoImpl.class);
		List<Person> list = dao.queryAll();
		Iterator<Person> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
