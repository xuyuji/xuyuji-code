package lab;

import java.util.Random;

/**
 * 费马检测
 * 费马小定理:如果n是一个素数，a是小于n的任意正整数，那么a的n次方与a模n同余。
 * a^n ≡ a(mod n)
 * a^n mod n = a mod n
 * a^n mod n = a
 * 普通计算方法是直接算出a^n,但是很容易溢出。
 * 求模运算规则之一
 * (a * b) mod p = ( (a mod p) * (b mod p) ) mod p
 * @author xuyuji
 *
 */
public class Lab13 {
	
	private Random random = new Random();
	
	private int square(int n){
		return n * n;
	}
	
	/**
	 * 幂求模
	 * @param a	0 < a < n
	 * @param exp 指数
	 * @param n 模
	 * @return
	 */
	private int expmod(int a, int exp, int n){
		if(exp == 0){
			return 1;
		}else if(exp % 2 == 0){
			//a^2n mod p = ( (a^n mod p) * (a^n mod p) ) mod p = (a^n mod p)² mod p
			return square( expmod(a, exp/2, n) ) % n;
		}else{
			//a^(n+1) mod p = ( (a^n mod p) * ( a mod p) ) mod p = ( (a^n mod p) * a) mod p
			return (expmod(a, exp-1, n) * a) % n;
		}
	}
	
	/**
	 * 费马检测
	 * @param n 所检测的数
	 * @return
	 */
	private boolean fermatDetection(int n){
		int a = random.nextInt(n - 1) + 1;
		if(a == expmod(a, n, n)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 素数必定符合费马小定理，符合费马小定理的数不一定是素数，不过概率很高。
	 * 每成功一次就加大可能性，多次检测基本可以确定是否为素数。
	 * @param n 所检测的数
	 * @param count 检测次数
	 * @return
	 */
	private boolean isPrimeNumber(int n, int count){
	    if(n < 2){
	        return false;
	    }
		for(int i = 0; i < count; i++){
			if(!fermatDetection(n)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Lab13 test = new Lab13();
		for(int i = 0; i <= 1000; i++){
			if(test.isPrimeNumber(i, 5)){
				System.out.println(i + "是素数");
			}
		}
	}
}
