package lab;

//现有整型数组{1，2，4，3，5，8}，写出一个函数，找出所有和为10的集合。
public class Lab2 {
	int[] a = { 1, 2, 4, 3, 5, 8 };
	int[] temp = { 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		new Lab2().function(0, 0);
	}

	public void function(int sum, int index) {
		if (sum == 10) {
			for (int i : temp) {
				System.out.print(i+"\t");
			}
			System.out.println();
		} else if (sum < 10) {
			for (int i = index; i < a.length; i++) {
				temp[i]++;
				function(sum + a[i], i);
				temp[i]--;
			}
		}
	}
}
