package lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间函数的简单使用
 * 
 * @author xuyuji
 *
 */
public class Lab7 {
	public static void main(String[] args) {
		System.out.println("=============test1=============");
		test1();
		System.out.println("=============test1=============");
		System.out.println("=============test2=============");
		test2();
		System.out.println("=============test2=============");
	}
	
	public static void test1(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
		
		System.out.println(sdf.format(calendar.getTime()));
		//星期天是第一天,这个值是固定的。setFirstDayOfWeek方法不会改变这个值，它是为了计算周的。
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		calendar.add(Calendar.YEAR, 5);
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
	}
	
	public static void test2(){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		Date date1, date2;
		Calendar calendar, calendar1, calendar2;
		try {
			date1 = sdf1.parse("2012-1-1");
			/**
			 *date1 = sdf1.parse("2012年1月1日");
			 *报错，格式要相同
			 **/
			System.out.println(date1);
			date2 = sdf2.parse("2013年3月3日");
			System.out.println(date2);
			
			calendar = Calendar.getInstance();
			calendar1 = Calendar.getInstance();
			calendar2 = Calendar.getInstance();
			
			calendar1.setTime(date1);
			calendar2.setTime(date2);
			
			System.out.println(sdf1.format(calendar.getTime()) + "比" 
					+ sdf2.format(calendar1.getTime()) + "早?"
					+ (calendar.before(calendar1)?"是的":"不是") );
			System.out.println(sdf1.format(calendar.getTime()) + "比" 
					+ sdf2.format(calendar2.getTime()) + "早?"
					+ (calendar.before(calendar2)?"是的":"不是") );
			System.out.println(sdf1.format(calendar.getTime()) + "比" 
					+ sdf2.format(calendar1.getTime()) + "晚?"
					+ (calendar.after(calendar1)?"是的":"不是") );
			System.out.println(sdf1.format(calendar.getTime()) + "比" 
					+ sdf2.format(calendar2.getTime()) + "晚?"
					+ (calendar.after(calendar2)?"是的":"不是") );
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
