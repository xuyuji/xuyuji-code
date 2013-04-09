package pattern.singleton;

public class SingletonDemo {
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		Singleton2 singleton2 = Singleton2.getInstance();
		
		System.out.println(singleton1.getName());
		System.out.println(singleton2.getName());
	}
}
