package chapter3;

/**
 * VM Args:-verbose:gc -XX:+PrintGCDetails
 * testGC()方法执行后，objA和objB会不会被GC呢？
 * @author xuyuji
 *
 */
public class ReferenceCountingGC {
	public Object instance = null;
	
	private static final int _1MB = 1024 * 1024;
	
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC(){
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
	}
	
	public static void main(String[] args) {
		ReferenceCountingGC.testGC();
	}
}
