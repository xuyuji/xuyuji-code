package pattern.singleton;

/**
 * 饿汉单例
 * @author xuyuji
 *
 */
public class Singleton2 {
	
	private static Singleton2 instance;
	
	private Singleton2(){}
	
	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
	
	public String getName(){
		return "饿汉";
	}
}
