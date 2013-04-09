package org.xuyuji.chapter22;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import static org.xuyuji.chapter22.SwingConsole.*;

public class FlowLayout1 extends JFrame {
	public FlowLayout1() {
		setLayout(new FlowLayout());
		for (int i = 0; i < 20; i++) {
			add(new JButton("Button" + i));
		}
	}

	public static void main(String[] args) {
		run(new FlowLayout1(), 300, 300);
	}
}
