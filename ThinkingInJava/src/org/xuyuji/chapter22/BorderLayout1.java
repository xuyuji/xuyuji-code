package org.xuyuji.chapter22;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import static org.xuyuji.chapter22.SwingConsole.*;

public class BorderLayout1 extends JFrame {
	public BorderLayout1() {
		add(BorderLayout.NORTH, new JButton("NORTH"));
		add(BorderLayout.CENTER, new JButton("CENTER"));
		add(BorderLayout.EAST, new JButton("EAST"));
		add(BorderLayout.WEST, new JButton("WEST"));
		add(BorderLayout.SOUTH, new JButton("SOUTH"));
	}

	public static void main(String[] args) {
		run(new BorderLayout1(), 300, 250);
	}
}
