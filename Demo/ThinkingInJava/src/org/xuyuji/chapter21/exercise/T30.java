package org.xuyuji.chapter21.exercise;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T30 {
	public static void main(String[] args) throws Exception {
		BlockingQueue<Character> bq = new LinkedBlockingQueue<Character>();
		Sender sender = new Sender(bq);
		Receiver receiver = new Receiver(bq);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
}

class Sender implements Runnable{
	Random rand = new Random(47);
	BlockingQueue<Character> bq;
	public Sender(BlockingQueue<Character> bq){
		this.bq = bq;
	}
	public void run(){
		try {
			while(true){
				for(char c = 'A'; c <= 'Z'; c++){
					bq.put(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e + " Sender interrupted");
		}
	}
}

class Receiver implements Runnable{
	BlockingQueue<Character> bq;
	public Receiver(BlockingQueue<Character> bq){
		this.bq = bq;
	}
	public void run(){
		try {
			while(true){
				char c;
					c = bq.take();
				System.out.println("Read " + c);
			}
		} catch (InterruptedException e) {
			System.out.println(e + " Receiver Interrupted");
		}
	}
}
