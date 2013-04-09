package org.xuyuji.chapter22;

import java.awt.FlowLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Hello Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);
		//验证setDefaultCloseOperation效果
//		new Timer().schedule(new TimerTask() {
//			public void run() {
//				System.out.println(1);
//			}
//		}, 1000, 1000);
		frame.setLayout(new FlowLayout());
		for(int i = 0; i < 10; i++){
			TimeUnit.SECONDS.sleep(1);
			frame.add(new JLabel(""+i));
		}
	}
}
