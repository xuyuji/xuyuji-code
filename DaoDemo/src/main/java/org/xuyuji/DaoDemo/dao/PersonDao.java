package org.xuyuji.DaoDemo.dao;

import java.util.List;

import org.xuyuji.DaoDemo.entity.Person;

public interface PersonDao {
	public List<Person> queryAll();
}
