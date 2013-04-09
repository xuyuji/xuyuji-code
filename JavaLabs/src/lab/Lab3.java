package lab;

//有两个序列a,b，大小都有n，序列元素的值任意整数，无序；
//要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b无素的和]之间的差最小。
//例如：  
//var a = [100, 99, 98, 1, 2, 3];
//var b = [1, 2, 3, 4, 5, 40];
public class Lab3 {
	public static void main(String[] args) {
		int[] a = { 100, 99, 98, 1, 2, 3 };
		int[] b = { 1, 2, 3, 4, 5, 40 };
		// int[] a = { 0, 67, 66 };
		// int[] b = { 68, 100, 101 };

		int sum_a = 0, sum_b = 0;
		new Lab3().play(a, b);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
			sum_a += a[i];
		}
		System.out.println("sum = " + sum_a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
			sum_b += b[i];
		}
		System.out.println("sum = " + sum_b);
	}

	public void play(int[] a, int[] b) {
		int sum_a = 0, sum_b = 0;
		int t = 0;
		int A = 0; // 两个数组差
		int a_i = 0, b_j = 0;
		boolean flag = false;

		for (int i = 0; i < a.length; i++)
			sum_a += a[i];
		for (int i = 0; i < b.length; i++)
			sum_b += b[i];
		A = sum_a - sum_b;
		if (A == 0) {
			return;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (Math.abs(A - (a[i] - b[j]) * 2) < Math.abs(A)) {
					flag = true;
					if (Math.abs(A - (a[i] - b[j]) * 2) < Math.abs(A
							- (a[a_i] - b[b_j]) * 2)) {
						a_i = i;
						b_j = j;
					}
				}
			}
		}
		if (flag == true) {
			System.out.println("交换a[" + a_i + "]:" + a[a_i] + "\tb[" + b_j
					+ "]:" + b[b_j]);
			t = a[a_i];
			a[a_i] = b[b_j];
			b[b_j] = t;
			play(a, b);
		}
	}
}
