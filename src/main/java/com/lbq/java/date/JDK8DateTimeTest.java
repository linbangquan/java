package com.lbq.java.date;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.junit.Test;

/**
 * jdk8中日期时间api的测试
 * @author 14378
 *
 */
public class JDK8DateTimeTest {

	@Test
	public void testDate() {
		//偏移量
		Date date1 = new Date(2020-1900, 9-1,8);
		System.out.println(date1);//Tue Sep 08 00:00:00 CST 2020
	}
	/**
	 * LocalDate、LocalTime、LocalDateTime的使用
	 * 说明：
	 * 	1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
	 *  2.类似于Calendar
	 */
	@Test
	public void test1() {
		//now():获取当前的日期、时间、日期+时间
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		
		//of():设置指定的年、月、日、时、分、秒。没有偏移量
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
		System.out.println(localDateTime1);
		
		//getXxx():获取相关的属性
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getDayOfWeek());
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getMonthValue());
		System.out.println(localDateTime.getMinute());
		
		//体现不可变性
		//withXxx():设置相关的属性
		LocalDate localDate1 = localDate.withDayOfMonth(22);
		System.out.println(localDate);
		System.out.println(localDate1);
		
		LocalDateTime localDateTime2 = localDateTime.withHour(4);
		System.out.println(localDateTime);
		System.out.println(localDateTime2);
		
		//不可变性
		LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
		System.out.println(localDateTime);
		System.out.println(localDateTime3);
		
		LocalDateTime localDateTime4 = localDateTime.minusDays(4);
		System.out.println(localDateTime);
		System.out.println(localDateTime4);
	}
	
	/**
	 * Instance的使用
	 * 类似于java.util.Date类
	 */
	@Test
	public void test2() {
		//now():获取本初子午线对应的标准时间
		Instant instant = Instant.now();
		System.out.println(instant);//2020-02-05T12:26:57.639Z
		
		//添加时间的偏移量
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);
		
		//toEpochMilli():获取自1970年1月1日0时0分0秒 (UTC)开始的毫秒数 ---> Date类的getTime()
		long milli = instant.toEpochMilli();
		System.out.println(milli);
		
		//ofEpochMilli():通过给定的毫秒数，获取Instant实例 --->Date(long millis)
		Instant instant1 = Instant.ofEpochMilli(milli);
		System.out.println(instant1);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);//2020-02-05T20:43:14.050
		System.out.println(OffsetDateTime.now());//2020-02-05T20:43:14.050+08:00
		System.out.println(OffsetDateTime.now().getOffset());//+08:00
		System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(0)));//2020-02-05T20:43:14.050Z
		System.out.println(localDateTime.toInstant(OffsetDateTime.now().getOffset()));//2020-02-05T12:43:14.050Z
		
		System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli());
		System.out.println(localDateTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli());
		System.out.println(System.currentTimeMillis());
	}
	/**
	 * DateTimeFormatter:格式化或者解析日期、时间
	 * 类似于SimpleDateFormat
	 */
	@Test
	public void test3() {
		//方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		//格式化：日期-->字符串
		LocalDateTime localDateTime = LocalDateTime.now();
		String str1 = formatter.format(localDateTime);
		System.out.println(localDateTime);//2020-02-05T21:10:24.729
		System.out.println(str1);//2020-02-05T21:10:24.729
		
		//解析：字符串 -->日期
		TemporalAccessor parse = formatter.parse("2020-02-05T21:10:24.729");
		System.out.println(parse);//{},ISO resolved to 2020-02-05T21:10:24.729
		
		//方式二：
		//本地化相关的格式。如：ofLocalizedDateTime()
		//FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT:适用于LocalDateTime
		DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		//格式化
		String str2 = formatter1.format(localDateTime);
		System.out.println(str2);//2020年2月5日 下午09时18分24秒
		
		//本地化相关的格式。如：ofLocalizedDate()
		//FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT:适用于LocalDate
		DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		//格式化
		String str3 = formatter2.format(localDateTime);
		System.out.println(str3);//2020-2-5
		
		//重点：
		//方式三：
		//自定义的格式。如:ofPattern("yyyy-MM-dd hh:mm:ss")
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//格式化
		String str4 = formatter3.format(LocalDateTime.now());
		System.out.println(str4);//2020-02-05 09:25:52
		
		//解析
		TemporalAccessor temporal = formatter3.parse("2020-02-05 09:25:52");
		System.out.println(temporal);//{},ISO resolved to 2020-02-05T09:25:52
		System.out.println(LocalDateTime.from(temporal));//2020-02-05T09:25:52
	}
}
