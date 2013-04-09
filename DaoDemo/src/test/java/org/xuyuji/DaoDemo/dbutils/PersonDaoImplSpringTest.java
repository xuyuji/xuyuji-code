package org.xuyuji.DaoDemo.dbutils;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xuyuji.DaoDemo.dao.PersonDao;
import org.xuyuji.DaoDemo.entity.Person;

public class PersonDaoImplSpringTest extends TestCase {
	public void testQueryAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/org/xuyuji/DaoDemo/dbutils/person.xml");
		PersonDao dao = context.getBean("personDaoImpl", PersonDaoImplSpring.class);
		List<Person> list = dao.queryAll();
		Iterator<Person> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
