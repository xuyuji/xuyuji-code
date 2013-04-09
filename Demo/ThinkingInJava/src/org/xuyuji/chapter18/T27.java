package org.xuyuji.chapter18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T27 {
	public void writeObject(Person p) throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("T27.out"));
		out.writeObject(p);
		out.close();
	}
	public Person readObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("T27.out"));
		return (Person) in.readObject();
	}
	public static void main(String[] args) throws Exception {
//		Person p = new Person();
//		p.setName("王尼马");
//		p.setAge(3);
//		p.setSex("男");
//		new T27().writeObject(p);
		
//		Person p = new Person();
//		p.setName("王尼美");
//		p.setAge(2);
//		p.setSex("女");
//		new T27().writeObject(p);
		
		Person p2 = new T27().readObject();
		System.out.println(p2);
	}
}

class Person implements Serializable{
	private String name;
	private int age;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String toString(){
		return "姓名:" + name + ",年龄:" + age + ",性别:" + sex;
	}
}
