package xuyuji;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UI {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		JFrame jf = new JFrame("UI-Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setVisible(true);
		jf.setLayout(new FlowLayout());
		jf.add(new JButton("abc"));
		jf.add(new JButton("abc"));
		jf.add(new JButton("abc"));
		jf.add(new JButton("abc"));
		jf.add(new JTextField(10));
	}
}
