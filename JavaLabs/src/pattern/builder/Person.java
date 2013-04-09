package pattern.builder;

public class Person{
	private String name;
	private int age;
	private String sex;
	private String address;
	private String tel;
	private String cardNo;
	
	public static class Builder{
		private String name;
		private String sex;
		private int age = 0;
		private String address = "";
		private String tel = "";
		private String cardNo = "";
		
		public Builder(String name, String sex){
			this.name = name;
			this.sex = sex;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
		}
		
		public Builder address(String address){
			this.address = address;
			return this;
		}
		
		public Builder tel(String tel){
			this.tel = tel;
			return this;
		}
		
		public Builder cardNo(String cardNo){
			this.cardNo = cardNo;
			return this;
		}
		
		public Person Build(){
			return new Person(this);
		}
	}
	
	private Person(Builder builder){
		this.name = builder.name;
		this.sex = builder.sex;
		this.age = builder.age;
		this.address = builder.address;
		this.tel = builder.tel;
		this.cardNo = builder.cardNo;
	}
	
	public String toString(){
		return "name:" + name +
				"\nsex:" + sex + 
				"\nage:" + age + 
				"\naddress:" + address + 
				"\ntel:" + tel + 
				"\ncardNo:" + cardNo;
	}
	
	public static void main(String[] args) {
		Person person = new Person.Builder("张三", "男").age(5).tel("4742488").Build();
		System.out.println(person);
	}
}