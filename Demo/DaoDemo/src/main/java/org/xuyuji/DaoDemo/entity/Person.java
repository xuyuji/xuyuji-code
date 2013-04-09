package org.xuyuji.DaoDemo.entity;

import java.util.Date;

public class Person {
	private int p_id;
	private String p_name;
	private String p_age;
	private String p_hobby;
	private Date p_birthday;
	private double p_wage;
	private String p_company;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_age() {
		return p_age;
	}

	public void setP_age(String p_age) {
		this.p_age = p_age;
	}

	public String getP_hobby() {
		return p_hobby;
	}

	public void setP_hobby(String p_hobby) {
		this.p_hobby = p_hobby;
	}

	public Date getP_birthday() {
		return p_birthday;
	}

	public void setP_birthday(Date p_birthday) {
		this.p_birthday = p_birthday;
	}

	public double getP_wage() {
		return p_wage;
	}

	public void setP_wage(double p_wage) {
		this.p_wage = p_wage;
	}

	public String getP_company() {
		return p_company;
	}

	public void setP_company(String p_company) {
		this.p_company = p_company;
	}

	public String toString(){
		return "[p_id:" + p_id + ",p_name:" + p_name + ",p_age:" + p_age + ",p_hobby:" + p_hobby + ",p_birthday:" + p_birthday + ",p_wage:" + p_wage + ",p_company:" + p_company + "]";
	}
}
