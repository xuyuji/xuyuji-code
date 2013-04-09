package org.xuyuji.chapter21;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test implements Runnable {
	private X x;
	public Test(X x){
		this.x = x;
	}
	public static void main(String[] args) {
//		ExecutorService e = Executors.newCachedThreadPool();
		X x = X.getInstance();
//		e.execute(new Test(x));
//		e.execute(new Test(x));
//		e.execute(new Test(x));
//		e.execute(new Test(x));
//		e.execute(new Test(x));
//		e.shutdown();
		for (int i = 0; i < 5; i++) {
			new Thread(new Test(x)).start();
		}
	}

	@Override
	public void run() {
		for (int j = 0; j < 10000000; j++) {
			int i = x.increment();
			if (i % 2 != 0) {
				System.out.println(i);
			} 
//			else {
//				System.out.print(i);
//			}
		}
	}

}

class X {
	private int i = 0;
	private static X x = new X();

	private X() {
	}

	public static X getInstance() {
		return x;
	}
	
	public synchronized int increment(){
		++i;
		++i;
		return i;
	}
}