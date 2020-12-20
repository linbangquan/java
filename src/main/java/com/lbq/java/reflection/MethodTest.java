package com.lbq.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 *	获取运行时类的方法结构
 * @author 14378
 *
 */
public class MethodTest {

	@Test
	public void test1() {
		Class<Person> clazz = Person.class;
		
		//getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
		Method[] methods = clazz.getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
//		public java.lang.String com.lbq.java.reflection.Person.toString()
//		public int com.lbq.java.reflection.Person.compareTo(java.lang.Object)
//		public int com.lbq.java.reflection.Person.compareTo(java.lang.String)
//		public java.lang.String com.lbq.java.reflection.Person.getName()
//		public int com.lbq.java.reflection.Person.getId()
//		public void com.lbq.java.reflection.Person.setName(java.lang.String)
//		public void com.lbq.java.reflection.Person.info()
//		public void com.lbq.java.reflection.Person.show()
//		public int com.lbq.java.reflection.Person.getAge()
//		public void com.lbq.java.reflection.Person.setAge(int)
//		public void com.lbq.java.reflection.Person.setId(int)
//		public java.lang.String com.lbq.java.reflection.Person.display(java.lang.String,int) throws java.lang.NullPointerException,java.lang.ClassCastException
//		public void com.lbq.java.reflection.Creature.eat()
//		public final void java.lang.Object.wait() throws java.lang.InterruptedException
//		public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//		public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//		public boolean java.lang.Object.equals(java.lang.Object)
//		public native int java.lang.Object.hashCode()
//		public final native java.lang.Class java.lang.Object.getClass()
//		public final native void java.lang.Object.notify()
//		public final native void java.lang.Object.notifyAll()
		System.out.println("----------------------------------------------------");
		
		//getDeclareMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method method : declaredMethods) {
			System.out.println(method);
		}
		
//		public java.lang.String com.lbq.java.reflection.Person.toString()
//		public int com.lbq.java.reflection.Person.compareTo(java.lang.Object)
//		public int com.lbq.java.reflection.Person.compareTo(java.lang.String)
//		public java.lang.String com.lbq.java.reflection.Person.getName()
//		public int com.lbq.java.reflection.Person.getId()
//		public void com.lbq.java.reflection.Person.setName(java.lang.String)
//		public void com.lbq.java.reflection.Person.info()
//		public void com.lbq.java.reflection.Person.show()
//		private java.lang.String com.lbq.java.reflection.Person.showNation(java.lang.String)
//		public int com.lbq.java.reflection.Person.getAge()
//		public void com.lbq.java.reflection.Person.setAge(int)
//		public void com.lbq.java.reflection.Person.setId(int)
//		public java.lang.String com.lbq.java.reflection.Person.display(java.lang.String,int) throws java.lang.NullPointerException,java.lang.ClassCastException
//		private static void com.lbq.java.reflection.Person.showDesc()
	}
	
	/**
	 * @Xxx
	 * 权限修饰符 返回值类型 方法名(参数类型1 形参名1, ...) throws XxxException{}
	 */
	@Test
	public void test2() {
		Class<Person> clazz = Person.class;
		
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method method : declaredMethods) {
			//1.获取方法声明的注解
			Annotation[] annotations = method.getAnnotations();
			for(Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//2.权限修饰符
			System.out.print(Modifier.toString(method.getModifiers()) + " ");
			//3.返回值类型
			System.out.print(method.getReturnType().getName() + " ");
			//4.方法名称
			System.out.print(method.getName());
			
			System.out.print("(");
			//5.形参列表
			Class[] parameterTypes = method.getParameterTypes();
			if(parameterTypes != null && parameterTypes.length > 0) {
				for(int i = 0; i < parameterTypes.length; i++) {
					if( i == parameterTypes.length - 1) {
						System.out.print(parameterTypes[i].getName() + " args_" + i);
						break;
					}
					System.out.print(parameterTypes[i].getName() + " args_" + i + ", ");
				}
			}
			System.out.print(")");
			//6.抛出的异常
			Class[] exceptionTypes = method.getExceptionTypes();
			if(exceptionTypes.length > 0) {
				System.out.print(" throws ");
				for(int i = 0; i < exceptionTypes.length; i++) {
					if(i == exceptionTypes.length - 1) {
						System.out.print(exceptionTypes[i].getName());
						break;
					}
					System.out.print(exceptionTypes[i].getName() + ", ");
				}
			}
			
//			System.out.println();
//			public java.lang.String toString()
//			public volatile int compareTo(java.lang.Object args_0)
//			public int compareTo(java.lang.String args_0)
//			public java.lang.String getName()
//			public int getId()
//			public void setName(java.lang.String args_0)
//			public void info()
//			public void setId(int args_0)
//			public void setAge(int args_0)
//			public int getAge()
//			@com.lbq.java.reflection.MyAnnotation(value=hello)
//			private java.lang.String showNation(java.lang.String args_0)
//			public java.lang.String display(java.lang.String args_0, int args_1) throws java.lang.NullPointerException, java.lang.ClassCastException
//			private static void showDesc()
//			public void show()
		}
	}
}
