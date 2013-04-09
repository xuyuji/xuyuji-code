package org.xuyuji.chapter22;

import static org.xuyuji.chapter22.SwingConsole.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.xuyuji.chapter17.Countries;

public class TextArea extends JFrame {
	private JButton b = new JButton("Add Data");
	private JButton c = new JButton("Clear Data");
	private JTextArea t = new JTextArea(20, 40);
	private Map<String, String> m = new HashMap<String, String>();

	public TextArea() {
		m.putAll(Countries.capitals());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Map.Entry me : m.entrySet())
					t.append(me.getKey() + ":" + me.getValue() + "\n");
			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(b);
		add(c);
	}

	public static void main(String[] args) {
		run(new TextArea(), 475, 425);
	}
}
