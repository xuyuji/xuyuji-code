package org.xuyuji.chapter22;

import static org.xuyuji.chapter22.SwingConsole.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class T5 extends JFrame {
	private JButton b1 = new JButton("b1");
	private JButton b2 = new JButton("b2");
	private JButton b3 = new JButton("b3");
	private JButton bclear = new JButton("clear");
	private JTextField t1 = new JTextField(10);

	private ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			t1.setText(((JButton) e.getSource()).getText() + " clicked!");
		}
	};
	private ActionListener clear = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
		}
	};
	
	public T5(){
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		bclear.addActionListener(clear);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(bclear);
		add(t1);
	}

	public static void main(String[] args) {
		run(new T5(), 300, 200);
	}
}
