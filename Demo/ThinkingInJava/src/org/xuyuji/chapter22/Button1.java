package org.xuyuji.chapter22;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import static org.xuyuji.chapter22.SwingConsole.*;

public class Button1 extends JFrame {
	private JButton b1 = new JButton("Button 1");
	private JButton b2 = new JButton("Button 2");

	public Button1() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}

	public static void main(String[] args) {
		run(new Button1(), 200, 100);
	}
}
