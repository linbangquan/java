package com.lbq.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class OtherTest {

	/**
	 * 	获取构造器结构
	 */
	@Test
	public void test1() {
		Class<Person> clazz = Person.class;
		//getConstuctors():获取当前运行时类中声明为public的构造器
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
//		public com.lbq.java.reflection.Person(java.lang.String,int)
//		public com.lbq.java.reflection.Person()
		System.out.println("============================");
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for(Constructor<?> constructor : declaredConstructors) {
			System.out.println(constructor);
		}
//		private com.lbq.java.reflection.Person(java.lang.String)
//		public com.lbq.java.reflection.Person(java.lang.String,int)
//		public com.lbq.java.reflection.Person()
	}
	/**
	 * 获取运行时类的父类
	 */
	@Test
	public void test2() {
		Class<Person> clazz = Person.class;
		
		Class<? super Person> superclass = clazz.getSuperclass();
		System.out.println(superclass);//class com.lbq.java.reflection.Creature
		System.out.println("============================");
		Class<?>[] interfaces = clazz.getInterfaces();
		if(interfaces != null && interfaces.length > 0) {
			for(Class<?> interface1 : interfaces) {
				System.out.println(interface1);
			}
		}
//		interface java.lang.Comparable
//		interface com.lbq.java.reflection.MyInterface
	}
	
	/**
	 * 获取运行时类的带泛型的父类
	 */
	@Test
	public void test3() {
		Class<Person> clazz = Person.class;
		
		Type genericSuperclass = clazz.getGenericSuperclass();
		System.out.println(genericSuperclass);
//		com.lbq.java.reflection.Creature<java.lang.String>
		System.out.println("============================");
		Type[] genericInterfaces = clazz.getGenericInterfaces();
		if(genericInterfaces != null && genericInterfaces.length > 0 ) {
			for(Type type : genericInterfaces) {
				System.out.println(type);
			}
		}
//		java.lang.Comparable<java.lang.String>
//		interface com.lbq.java.reflection.MyInterface
	}
	
	/**
	 * 	获取运行时类的带泛型的父类的泛型
	 * 	代码：逻辑性代码 vs 功能性代码
	 */
	@Test
	public void test4() {
		Class<Person> clazz = Person.class;
		
		Type genericSuperclass = clazz.getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) genericSuperclass;
		//获取泛型类型
		Type[] actualTypeArguments = paramType.getActualTypeArguments();
		System.out.println(actualTypeArguments[0].getTypeName());//java.lang.String
		System.out.println(((Class)actualTypeArguments[0]).getName());//java.lang.String
	}
	
	/**
	 * 获取运行时类实现的接口
	 */
	@Test
	public void test5() {
		Class<Person> clazz = Person.class;
		
		Class<?>[] interfaces = clazz.getInterfaces();
		if(interfaces != null && interfaces.length > 0) {
			for(Class<?> interface1 : interfaces) {
				System.out.println(interface1);
			}
		}
//		interface java.lang.Comparable
//		interface com.lbq.java.reflection.MyInterface
		System.out.println("======================================");
		Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
		if(interfaces1 != null && interfaces1.length > 0) {
			for(Class<?> interface1 : interfaces1) {
				System.out.println(interface1);
			}
		}
//		interface java.io.Serializable
	}
	
	/**
	 * 获取运行时类所在的包
	 */
	@Test
	public void test6() {
		Class<Person> clazz = Person.class;
		
		Package pack = clazz.getPackage();
		System.out.println(pack);//package com.lbq.java.reflection
	}
	
	/**
	 * 获取运行时类声明的注解
	 */
	@Test
	public void test7() {
		Class<Person> clazz = Person.class;
		
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation annos : annotations) {
			System.out.println(annos);
		}
		//@com.lbq.java.reflection.MyAnnotation(value=hi)
	}
}
