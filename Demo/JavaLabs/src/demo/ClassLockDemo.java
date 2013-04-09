package demo;

import java.util.concurrent.TimeUnit;

/**
 * synchronized static方法会获得类锁
 * @author xuyuji
 *
 */
public class ClassLockDemo implements Runnable{
	public synchronized static void x1(){
		while(true){
			try {
				System.out.println("x1");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized static void x2(){
		while(true){
			try {
				System.out.println("x2");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//主线程的x2先执行，获得类锁
	//若取消注释，主线程休眠1秒钟，则x1线程先跑获得类锁
	public static void main(String[] args) {
		System.out.println("x1 go!");
		new Thread(new ClassLockDemo()).start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("x2 go!");
		ClassLockDemo.x2();
	}
	public void run() {
		x1();
	}
}
