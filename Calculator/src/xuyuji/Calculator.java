package xuyuji;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 简单计算器
 * 看了thinking in java图形界面几章后练手之作。
 * 比较粗糙，应该有bug。
 * 
 * @author xuyuji
 *
 */
public class Calculator extends JFrame {
	private JTextField jt = new JTextField(10);
	private JButton b_1 = new JButton("1");
	private JButton b_2 = new JButton("2");
	private JButton b_3 = new JButton("3");
	private JButton b_4 = new JButton("4");
	private JButton b_5 = new JButton("5");
	private JButton b_6 = new JButton("6");
	private JButton b_7 = new JButton("7");
	private JButton b_8 = new JButton("8");
	private JButton b_9 = new JButton("9");
	private JButton b_0 = new JButton("0");
	private JButton b_dot = new JButton(".");
	private JButton b_C = new JButton("C");
	private JButton b_d = new JButton("<-");
	private JButton b_add = new JButton("+");
	private JButton b_del = new JButton("-");
	private JButton b_mul = new JButton("*");
	private JButton b_exc = new JButton("/");
	private JButton b_rem = new JButton("%");
	private JButton b_rec = new JButton("1/x");
	
	private JButton b_result = new JButton("=");
	
	private double a = 0, b = 0;
	private int actionType = 0;
	private boolean flag = false;
	
	private ActionListener al_num = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String s1;
			if(flag){
				s1 = "0";
				a = 0;
				b = 0;
				actionType = 0;
				flag = false;
			}else{
				s1 = jt.getText();
			}
			String s2 = ((JButton)e.getSource()).getText();
			if("0".equals(s1) || actionType > 0){
				jt.setText(s2);
			}else{
				jt.setText(s1 + s2);
			}
		}
	};
	private ActionListener al_dot = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String str;
			if(flag){
				str = "0";
				a = 0;
				b = 0;
				actionType = 0;
				flag = false;
			}else{
				str = jt.getText();
			}
			if(str != null && str.indexOf(".") == -1)
				jt.setText(str + ((JButton)e.getSource()).getText());
		}
	};
	private ActionListener al_C = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jt.setText("0");
			a = 0;
			b = 0;
			actionType = 0;
			flag = false;
		}
	};
	private ActionListener al_del = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String str = jt.getText();
			if(str.length() <= 1){
				jt.setText("0");
			}else{
				jt.setText(str.substring(0,str.length()-1));
			}
		}
	};
	private ActionListener al_operator = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(actionType == 0 || flag){
				a = Double.parseDouble(jt.getText());
			}else{
				b = Double.parseDouble(jt.getText());
				try{
					switch(actionType){
						case 1:
							a += b;
							break;
						case 2:
							a -= b;
							break;
						case 3:
							a *= b;
							break;
						case 4:
							a /= b;
							break;
						case 5:
							a %= b;
							break;
						default:
							a = Double.parseDouble(jt.getText());
					}
				}catch (Exception ex) {
					jt.setText("0");
				}
			}
			
			String b_text = ((JButton)e.getSource()).getText();
			if("+".equals(b_text)){
				actionType = 1;
			}else if("-".equals(b_text)){
				actionType = 2;
			}else if("*".equals(b_text)){
				actionType = 3;
			}else if("/".equals(b_text)){
				actionType = 4;
			}else if("%".equals(b_text)){
				actionType = 5;
			}
			
			String result = a + "";
			if(".0".equals(result.substring(result.length()-2, result.length()))){
				result = result.substring(0, result.length()-2);
			}
			jt.setText(result);
			b = 0;
			flag = false;
		}
	};
	private ActionListener al_reciprocal = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Double d = Double.parseDouble(jt.getText());
			if(d != 0){
				String result = 1/d + "";
				if(".0".equals(result.substring(result.length()-2, result.length()))){
					result = result.substring(0, result.length()-2);
				}
				jt.setText(result);
				actionType = 6;
				flag = true;
			}
		}
	};
	private ActionListener al_result = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(b == 0)
				b = Double.parseDouble(jt.getText());
			switch(actionType){
				case 1:
					a += b;
					break;
				case 2:
					a -= b;
					break;
				case 3:
					a *= b;
					break;
				case 4:
					a /= b;
					break;
				case 5:
					a %= b;
					break;
				case 6:
					return;
				default:
					a = Double.parseDouble(jt.getText());
			}
			String result = a + "";
			if(".0".equals(result.substring(result.length()-2, result.length()))){
				result = result.substring(0, result.length()-2);
			}
			jt.setText(result);
			flag = true;
		}
	};
	
	public Calculator(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(200, 300);
		setBounds(300, 300, 200, 300);
		setVisible(true);
		setResizable(false);
		
		setLayout(new GridLayout(6, 1));
		//设置事件
		b_1.addActionListener(al_num);
		b_2.addActionListener(al_num);
		b_3.addActionListener(al_num);
		b_4.addActionListener(al_num);
		b_5.addActionListener(al_num);
		b_6.addActionListener(al_num);
		b_7.addActionListener(al_num);
		b_8.addActionListener(al_num);
		b_9.addActionListener(al_num);
		b_0.addActionListener(al_num);
		b_dot.addActionListener(al_dot);
		b_C.addActionListener(al_C);
		b_d.addActionListener(al_del);
		b_add.addActionListener(al_operator);
		b_del.addActionListener(al_operator);
		b_mul.addActionListener(al_operator);
		b_exc.addActionListener(al_operator);
		b_rem.addActionListener(al_operator);
		b_rec.addActionListener(al_reciprocal);
		
		b_result.addActionListener(al_result);
		//第一行
		jt.setEditable(false);
		jt.setText("0");
		jt.setHorizontalAlignment(JTextField.RIGHT);
		add(jt);
		//第二行 
		JPanel jp2 = new JPanel();
		jp2.add(b_7);
		jp2.add(b_8);
		jp2.add(b_9);
		jp2.add(b_exc);
		jp2.add(b_rem);
		add(jp2);
		//第三行
		JPanel jp3 = new JPanel();
		jp3.add(b_4);
		jp3.add(b_5);
		jp3.add(b_6);
		jp3.add(b_mul);
		jp3.add(b_rec);
		add(jp3);
		//第四行
		JPanel jp4 = new JPanel();
		jp4.add(b_1);
		jp4.add(b_2);
		jp4.add(b_3);
		jp4.add(b_del);
		jp4.add(b_d);
		add(jp4);
		//第五行
		JPanel jp5 = new JPanel();
		jp5.add(b_0);
		jp5.add(b_dot);
		jp5.add(b_C);
		jp5.add(b_add);
		jp5.add(b_result);
		add(jp5);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		Calculator t = new Calculator();
	}
}
