package com.lbq.java.otherclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger和BigDecimal
 * 
 * @author 14378
 *
 */
public class OtherClassTest {

	@Test
	public void test1() {
		String javaVersion = System.getProperty("java.version");
		System.out.println("java的version:" + javaVersion);
		
		String javaHome = System.getProperty("java.home");
		System.out.println("java的home:" + javaHome);
		
		String osName = System.getProperty("os.name");
		System.out.println("os的name:" + osName);
		
		String osVersion = System.getProperty("os.version");
		System.out.println("os的version:" + osVersion);
		
		String userName = System.getProperty("user.name");
		System.out.println("user的name:" + userName);
		
		String userHome = System.getProperty("user.home");
		System.out.println("user的home:" + userHome);
		
		String userDir = System.getProperty("user.dir");
		System.out.println("user的dir:" + userDir);
		System.out.println("*********************************************************");
		Map<String, String> env = System.getenv();
		for(Entry<String, String> entry : env.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("*********************************************************");
		Properties properties = System.getProperties();
		for(Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey().toString()+":"+entry.getValue().toString());
		}
	}
	
	@Test
	public void test2() {
		BigInteger bi = new BigInteger("124233323445533234544332324243464556453547676867879907441546");
		System.out.println(bi);
		
		BigDecimal bd = new BigDecimal("12435.351");
		BigDecimal bd2 = new BigDecimal("11");
//		System.out.println(bd.divide(bd2));
		System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
		System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
	}
}
