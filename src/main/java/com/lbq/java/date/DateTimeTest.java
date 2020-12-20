package com.lbq.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * JDK 8 之前日期和时间的API测试
 * 1. System类中currentTimeMillis();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 * @author 14378
 *
 */
public class DateTimeTest {

	//1.System类中的currentTimeMillis()
	@Test
	public void test1() {
		//返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差，称为时间戳
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
	/**
	 * java.util.Date类
	 * 		|---java.sql.Date类
	 * 1.两个构造器的使用
	 * 		>构造器一：Date():创建一个对应当前时间的Date对象
	 * 		>构造器二：创建指定毫秒数的Date对象
	 * 2.两个方法的使用
	 * 		>toString():显示当前的年、月、日、时、分、秒
	 * 		>getTime():获取当前Date对象对应的毫秒数。（时间戳）
	 * 3.java.sql.Date对应着数据库中的日期类型的变量
	 * 		>如何实例化
	 * 		>如何将java.util.Date对象转换为java.sql.Date对象
	 */
	@Test
	public void test2() {
		//构造器一：Date():创建一个对应当前时间的Date对象
		Date date1 = new Date();
		System.out.println(date1.toString());//Sat Jan 18 22:39:41 CST 2020
		
		System.out.println(date1.getTime());//1579358381464
		
		//构造器二：创建指定毫秒数的Date对象
		Date date2 = new Date(1579358381464L);
		System.out.println(date2.toString());//Sat Jan 18 22:39:41 CST 2020
		
		//创建java.sql.Date对象
		java.sql.Date date3 = new java.sql.Date(1579358381464L);
		System.out.println(date3);//2020-01-18
		
		//如何将java.util.Date对象转换为java.sql.Date对象
		//情况一：
		Date date4 = new java.sql.Date(1579358381464L);
		java.sql.Date date5 = (java.sql.Date) date4;
		System.out.println(date5);
		
		//情况二：
		Date date6 = new Date();
		java.sql.Date date7 = new java.sql.Date(date6.getTime());
		System.out.println(date7);
	}
	/**
	 * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
	 * 1. 两个操作：
	 * 1.1 格式化：日期 ---> 字符串
	 * 1.2 解析：格式化的逆过程，字符串 ---> 日期
	 * 
	 * 2. SimpleDateFormat的实例化
	 * @throws ParseException 
	 */
	@Test
	public void testSimpleDateFormat() throws ParseException {
		//实例化SimpleDateFormat:使用默认的构造器
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		//格式化：日期 ---> 字符串
		Date date = new Date();
		System.out.println(date);//Wed Feb 05 13:33:14 CST 2020
		
		System.out.println(sdf.toPattern());//yy-M-d ah:mm
		String format = sdf.format(date);
		System.out.println(format);//20-2-5 下午1:33
		
		//解析：格式化的逆过程，字符串 ---> 日期
		String str = "20-2-5 下午1:33";
		Date date1 = sdf.parse(str);
		System.out.println(date1);
		
		/*******************按照指定的方式格式化和解析：调用带参的构造器********************/
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");//2020.二月.05 公元 01:44 下午
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//2020-02-05 01:44:51
		//格式化
		String format1 = sdf1.format(date);
		System.out.println(format1);
		//解析：要求字符串必须是符合SimpleDateFormat识别的格式(通用构造器参数体现)，否则，抛异常
		Date date2 = sdf1.parse("2020-02-05 01:44:51");
		System.out.println(date2);
	}
	/**
	 * 练习一：字符串"2020-09-08"转换为java.sql.Date
	 * 
	 * 练习二："三天打鱼两天晒网"	1990-01-01	xxxx-xx-xx打鱼？晒网？
	 * 
	 * 举例：2020-09-08 ？总天数
	 * 
	 * 总天数 % 5 == 1,2,3 : 打鱼
	 * 总天数 % 5 == 4,0 : 晒网
	 * 
	 * 总天数的计算?
	 * 方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
	 * 方式二：1990-01-01 ---> 2019-12-31 + 2020-01-01 --->2020-09-08
	 * @throws ParseException 
	 */
	@Test
	public void testExer() throws ParseException {
		String birth = "2020-09-08";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf1.parse(birth);	
		System.out.println(date);
		
		java.sql.Date birthDate = new java.sql.Date(date.getTime());
		System.out.println(birthDate);
	}
	
	/**
	 * Calendar日历类(抽象类)的使用
	 */
	@Test
	public void testCalendar() {
		//1.实例化
		//方式一：创建其子类(GregorianCalendar)的对象
		//方式二：调用其静态方法getInstance()
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getClass());//class java.util.GregorianCalendar
		
		//2.常用方法
		//get()
		int days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		
		//set()
		//calendar可变性
		calendar.set(Calendar.DAY_OF_MONTH, 22);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		//add()
		calendar.add(Calendar.DAY_OF_MONTH, -3);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		//getTime():日历类 --->Date
		Date date = calendar.getTime();
		System.out.println(date);
		
		//setTime():Date ---> 日历类
		Date date1 = new Date();
		calendar.setTime(date1);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
	}
	
	@Test
	public void testCalendar2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.getTime());
		calendar.set(2020, 0, 1);
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println(calendar.get(Calendar.YEAR));
		int count = 1;
		while(calendar.get(Calendar.YEAR) == 2020) {
			System.out.println(count + ":" + sdf.format(calendar.getTime()) + ":" + calendar.get(Calendar.DAY_OF_MONTH) + ":" + calendar.get(Calendar.DAY_OF_WEEK) + ":" + calendar.get(Calendar.DAY_OF_YEAR) + ":" + calendar.get(Calendar.MONTH));
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			count ++;
		}
		
	}
	
}
