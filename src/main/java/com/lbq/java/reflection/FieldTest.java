package com.lbq.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * 	获取当前运行时类的属性结构
 * @author 14378
 *
 */
public class FieldTest {
	
	@Test
	public void test1() {
		Class<Person> clazz = Person.class;
		
		//获取属性结构
		//getFields():获取当前运行时类及其父类中声明为public访问权限的属性
		Field[] fields = clazz.getFields();
		for(Field field : fields) {
			System.out.println(field);
		}
//		public int com.lbq.java.reflection.Person.age
//		public int com.lbq.java.reflection.Person.id
//		public double com.lbq.java.reflection.Creature.weight
		System.out.println("==================================================");
		
		//getDeclaredFields()：获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
		Field[] declaredFields = clazz.getDeclaredFields();
		for(Field field : declaredFields) {
			System.out.println(field);
		}
//		private java.lang.String com.lbq.java.reflection.Person.name
//		public int com.lbq.java.reflection.Person.age
//		public int com.lbq.java.reflection.Person.id
 	}
	
	//权限修饰符 数据类型 变量名
	@Test
	public void test2() {
		Class<Person> clazz = Person.class;
		Field[] declaredFields = clazz.getDeclaredFields();
		for(Field field : declaredFields) {
			//1.权限修饰符
			int modifier = field.getModifiers();
			System.out.print(Modifier.toString(modifier) + " ");
			
			//2.数据类型
			Class<?> type = field.getType();
			System.out.print(type.getName() + " ");
			
			//3.变量名
			String fName = field.getName();
			System.out.print(fName);
			
			System.out.println();
		}
	}
}
