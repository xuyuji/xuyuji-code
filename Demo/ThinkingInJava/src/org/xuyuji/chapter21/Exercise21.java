package org.xuyuji.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise21 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ThreadA a = new ThreadA();
		exec.execute(a);
		exec.execute(new ThreadB(a));
		exec.shutdown();
	}
}

class ThreadA implements Runnable {
	@Override
	public void run() {
		System.out.println("ThreadA start...");
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadA end...");
	}
}

class ThreadB implements Runnable {
	private ThreadA a;
	public ThreadB(ThreadA a){
		this.a = a;
	}
	@Override
	public void run() {
		System.out.println("ThreadB start...");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (a) {
			a.notify();
		}
		System.out.println("ThreadB end...");
	}
}