package lab;

/**
 * 你是山西的一个煤老板，你在矿区开采了有3000吨煤需要运送到市场上去卖， 从你的矿区到市场有1000公里，你手里有一列烧煤的火车，这个火车最多只能
 * 装1000吨煤，且其能耗比较大——每一公里需要耗一吨煤。请问，作为一个懂 编程的煤老板的你，你会怎么运送才能运最多的煤到集市？
 * 
 * @author xuyuji
 * 
 */
public class Lab5 {
	public static void main(String[] args) {
		System.out.println(new Lab5().run(3000, 1000, 1000, 1));
	}

	/**
	 * @param a
	 *            总煤量，单位吨。
	 * @param b
	 *            路程，单位公里。
	 * @param c
	 *            火车运载量，单位吨。
	 * @param d
	 *            火车每公里消耗煤量，单位吨。
	 * @return >0 为求得结果； =-1 输入参数有误； =-2无法运达；
	 */
	public double run(double a, double b, double c, double d) {
		if (a <= 0 || b <= 0 || c <= 0 || d <= 0)
			return -1;

		int x = 0;
		double y = 0, z = 0;
		int t = 1000;
		// 满车的前提下一点点向前运，t是我设置的精度，比如t=1000的时候一次循环就是运送1/1000公里。t越大结果越精确
		for (int i = 0; i < b * t; i++) {
			x = (int) ((a - z) / c);
			y = (a - z) % c;
			// 因为最后一次火车不需要返回，所以该次列车跑的次数即为(2*x + (y==0?-1:1))。z是消耗的煤量，这里累加。
			z += (2 * x + (y == 0 ? -1 : 1)) * d / t;
			if (z > a) {
				return -2;
			}
		}
		return a - z;
	}
}