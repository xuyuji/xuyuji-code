package org.xuyuji.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 implements Runnable{
	private static int a = 0;
	private static int b = 0;
	public void run(){
		this.test();
	}
	public  void test(){
		while(true){
			a++;		
			b++;
			if(a == b)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	public static void main(String[] args) {
		new Test2().run();
		new Test2().run();
	}

}