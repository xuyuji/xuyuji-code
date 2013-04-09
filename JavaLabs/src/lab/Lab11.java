package lab;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Arrays.sort
 * Comparator用法
 * @author xuyuji
 *
 */
public class Lab11 {
	public static void main(String[] args) {
		Lab11 lab11 = new Lab11();
		Integer[] intArray = {5,6,4,2,8,3,2,1,4,7,4,8,9};
		printArrayInt(intArray);
		//这里不加Comparator效果是一样，默认是升序，这里只是演示Comparator用法。
		Arrays.sort(intArray, lab11.new ComparatorIntAsc());
		printArrayInt(intArray);
		Arrays.sort(intArray, lab11.new ComparatorIntDesc());
		printArrayInt(intArray);
		
		Calendar calendar = Calendar.getInstance();
		Date d1, d2, d3, d4, d5;
		d1 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		d2 = calendar.getTime();
		calendar.add(Calendar.DATE, -5);
		d3 = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		d4 = calendar.getTime();
		calendar.add(Calendar.MONTH, -3);
		d5 = calendar.getTime();
		Date[] dates = {d1, d2, d3, d4, d5};
		printArrayDate(dates);
		Arrays.sort(dates);
		printArrayDate(dates);
		Arrays.sort(dates, lab11.new ComparatorDateDesc());
		printArrayDate(dates);
	}
	
	public static void printArrayInt(Integer[] nums){
		for(Integer num : nums){
			System.out.print(num + " ");
		}
		System.out.println("\n============================");
	}
	
	public static void printArrayDate(Date[] dates){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Date date : dates){
			System.out.println(sdf.format(date));
		}
		System.out.println("============================");
	}
	/**
	 * Integer升序Comparator
	 * @author xuyuji
	 *
	 */
	class ComparatorIntAsc implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}
	/**
	 * Integer降序Comparator
	 * @author xuyuji
	 *
	 */
	class ComparatorIntDesc implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	/**
	 * Date降序Comparator
	 * @author xuyuji
	 *
	 */
	class ComparatorDateDesc implements Comparator<Date>{
		@Override
		public int compare(Date o1, Date o2) {
			return o2.compareTo(o1);
		}
	}
}
