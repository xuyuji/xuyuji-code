package org.xuyuji.chapter22;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JTextField jt = new JTextField(10);
		jt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(((JTextField) e.getSource()).getText());
			}
		});
		jf.add(BorderLayout.NORTH, jt);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
}
