package lab;

/**
 * 计算二进制数中1的个数
 * @author xuyuji
 *
 */
public class Lab10 {
	public static void main(String[] args) {
		long l = 242342423234234L;
		System.out.println(Long.toBinaryString(l));
		System.out.println("'1' num:" + count2(l));
	}
	/**
	 * 一位一位遍历
	 * @param l
	 * @return
	 */
	public static long count1(long l){
		long i = 0, count = 0;
		while(l > 0){
			i = l%2;
			l = l/2;
			if(i == 1){
				count++;
			}
		}
		return count;
	}
	/**
	 * 每次循环去除最后一个1
	 * 循环次数既是1的个数
	 * @param l
	 * @return
	 */
	public static long count2(long l){
		long count = 0;
		while(l > 0){
			l &= l - 1;
			count++;
		}
		return count;
	}
}
