package org.xuyuji.DaoDemo.jdbctemplate;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.xuyuji.DaoDemo.dao.PersonDao;
import org.xuyuji.DaoDemo.entity.Person;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao {

	public List<Person> queryAll() {
		return getJdbcTemplate().query("select * from person", new BeanPropertyRowMapper(Person.class));
	}

}
