package pattern.singleton;

/**
 * 饱汉单例
 * @author xuyuji
 *
 */
public class Singleton1 {
	
	private static Singleton1 instance = new Singleton1();
	
	private Singleton1(){}
	
	public static Singleton1 getInstance(){
		return instance;
	}
	
	public String getName(){
		return "饱汉";
	}
}
