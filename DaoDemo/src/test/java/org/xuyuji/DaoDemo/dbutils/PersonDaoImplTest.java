package org.xuyuji.DaoDemo.dbutils;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.xuyuji.DaoDemo.dao.PersonDao;
import org.xuyuji.DaoDemo.entity.Person;

public class PersonDaoImplTest extends TestCase {
	public void testQueryAll(){
		PersonDao dao = new PersonDaoImpl();
		List<Person> list = dao.queryAll();
		Iterator<Person> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
