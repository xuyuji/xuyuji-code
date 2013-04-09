package org.xuyuji.chapter22;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import static org.xuyuji.chapter22.SwingConsole.*;

public class T11 extends JFrame{
	private class MyButton extends JButton{
		private Random r = new Random(); 
		
		public MyButton(String name){
			super(name);
			addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					
				}
				public void mousePressed(MouseEvent e) {
					
				}
				public void mouseExited(MouseEvent e) {
					
				}
				public void mouseEntered(MouseEvent e) {
					
				}
				public void mouseClicked(MouseEvent e) {
					setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				}
			});
		}
	}
	
	public T11(){
		add(new MyButton("changeColor"));
//		setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		run(new T11(), 800, 600);
	}
}
