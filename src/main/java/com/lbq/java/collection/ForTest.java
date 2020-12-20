package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * 	jdk5.0新增了foreach循环，用于遍历集合、数组
 * @author 14378
 *
 */
public class ForTest {
	
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		
		//for(集合元素的类型 局部变量 ：集合对象)
		//内部仍然调用了迭代器。
		for(Object obj : coll) {
			System.out.println(obj);
		}
	}
	
	@Test
	public void test2() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6};
		//for(数组元素类型 局部变量 ： 数组对象)
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	//练习题
	@Test
	public void test3() {
		String[] arr = new String[] {"MM", "MM", "MM"};
		
		//方式一：普通for赋值
		for(int i = 0; i < arr.length; i++) {
			arr[i] = "GG";
		}
		
		//方式二：增强for循环
		for(String s : arr) {
			s = "OO";
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	@Test
	public void test4() {
		Person[] arr = new Person[5];
		arr[0] = new Person("a", 1);
		arr[1] = new Person("b", 2);
		arr[2] = new Person("c", 3);
		arr[3] = new Person("d", 4);
		arr[4] = new Person("e", 5);
		
		for(Person person : arr) {
			//person = new Person("f", 6);//arr不变
			person.setAge(10);
		}
		
		for(Person person : arr) {
			System.out.println(person);
		}
	}
	
	@Test
	public void test5() {
		List<Person> personList = new ArrayList<>();
		Person person = new Person("f", 6);
		change(personList, person);
		System.out.println("personList:"+personList);//personList:[]
		System.out.println(person);//Person [name=f, age=6]
	}

	private void change(List<Person> personList, Person person) {
		List<Person> personList2 = new ArrayList<>();
		personList2.add(new Person("a", 1));
		personList2.add(new Person("b", 2));
		personList2.add(new Person("c", 3));
		personList2.add(new Person("d", 4));
		personList2.add(new Person("e", 5));
		System.out.println("personList2:"+personList2);//personList2:[Person [name=a, age=1], Person [name=b, age=2], Person [name=c, age=3], Person [name=d, age=4], Person [name=e, age=5]]
		personList = personList2;
		System.out.println("personList:"+personList);//personList:[Person [name=a, age=1], Person [name=b, age=2], Person [name=c, age=3], Person [name=d, age=4], Person [name=e, age=5]]
		person = new Person("g", 7);
	}
	
	
}
