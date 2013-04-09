package mvel;

import org.mvel2.MVEL;

public class MvelTest {
	public static void main(String[] args) {
		String exp = "(300*4-5/10)*1.234";
		System.out.println(MVEL.eval(exp));
	}
}
