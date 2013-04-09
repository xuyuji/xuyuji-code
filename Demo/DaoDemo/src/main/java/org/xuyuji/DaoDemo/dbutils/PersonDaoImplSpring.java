package org.xuyuji.DaoDemo.dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.xuyuji.DaoDemo.dao.PersonDao;
import org.xuyuji.DaoDemo.entity.Person;

public class PersonDaoImplSpring implements PersonDao{
	
	private QueryRunner run;
	
	public void setRun(QueryRunner run) {
		this.run = run;
	}

	public List<Person> queryAll() {
		ResultSetHandler<List<Person>> h = new BeanListHandler<Person>(Person.class);
		List<Person> list = null;
		try {
			list = run.query("select * from person", h);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null){
			list = new ArrayList<Person>();
		}
		
		return list;
	}
}
