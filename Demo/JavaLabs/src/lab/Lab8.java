package lab;

/**
 * 不使用系统函数翻转字符串 效果如下：
 * asd,fsdf.gfg  gdg 
 * gdg  gfg.fsdf,asd
 * 
 * @author xuyuji
 * 
 */
public class Lab8 {
	public static void main(String[] args) {
		System.out.println(reverse("asd,fsdf.gfg  gdg".toCharArray()));
		System.out.println(reverse("9ujf093u4fj.,,mskldjf".toCharArray()));
		System.out.println(reverse("j.,/m".toCharArray()));
	}
	
	public static char[] reverse(char[] source) {
		int len = source.length, t = 0;
		char[] target = new char[len];

		for (int i = 0; i < len; i++) {
			if (!isWord(source[i])) {
				copy(source, target, t, i);
				t = i + 1;
				target[len - i - 1] = source[i];
			}
		}
		copy(source, target, t, len);

		return target;
	}
	
	public static boolean isWord(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;
		else
			return false;
	}
	
	public static void copy(char[] source, char[] target, int start, int end) {
		if (start >= end) {
			return;
		}
		// 求两字符串的距离，化简下式
		// int len = source.length - 2 * start - (end - start);
		int len = source.length - start - end;
		for (int i = start; i < end; i++) {
			target[i + len] = source[i];
		}
	}
}
