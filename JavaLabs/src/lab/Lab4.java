package lab;

//快速排序
public class Lab4 {
	public static void main(String[] args) {
		int[] array = { 25, 070, 4, 20, 57, 0, 9, 7456, 48, 0, 6, 8, 3, 4, 5 };
		Lab4 test = new Lab4();
		test.quickSort(array);
		test.printArray(array);
	}

	public int[] quickSort(int[] array_) {
		int[] array = array_;

		quickSort_(array, 0, array.length - 1);

		return array;
	}

	private void quickSort_(int[] array, int left, int right) {
		if (right > left) {
			int index = left;
			for (int i = left; i < right; i++) {
				if (array[i] < array[right]) {
					swap(array, index++, i);
				}
			}
			swap(array, index, right);
			quickSort_(array, left, index - 1);
			quickSort_(array, index + 1, right);
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
//		printArray(array);
	}

	public void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + "\t");
		System.out.println();
	}
}
