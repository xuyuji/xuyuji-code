package chapter4;

/**
 * Integer.valueOf()为节省开销，[-128,127]之间数字都会缓存，所以两线程操作的是相同的两个对象。
 * @author xuyuji
 *
 */
public class MonitoringTest4_8 {
	static class SynAddRunable implements Runnable{
		int a, b;
		public SynAddRunable(int a, int b){
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++){
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}
	}
}
