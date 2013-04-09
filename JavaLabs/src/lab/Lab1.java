package lab;

//问题是这样，有N个数字，数值不同，要列出用他们不同的组合相加等于1000的情况。
//比如，a[3]={200,300,400}
//则有的情况为：
//5 0 0
//3 0 1
//2 2 0
//1 0 2
//0 2 1
//等情况。
public class Lab1 {
	int[] a = { 200, 300, 400 };
	int[] temp = { 0, 0, 0 };

	public static void main(String[] args) {
		new Lab1().function(0, 0);
	}

	public void function(int sum, int index) {
		int j, i;

		if (sum == 1000) {
			for (j = 0; j < 3; j++)
				System.out.print(temp[j] + " ");
			System.out.println();
			return;
		} else if (sum > 1000) {
			return;
		} else {
			for (i = index; i < 3; i++) {
				temp[i]++;
				function(sum + a[i], i);
				temp[i]--;
			}
		}
	}
}
