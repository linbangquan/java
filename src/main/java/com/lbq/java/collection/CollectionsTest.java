package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Collections：操作Collection、Map的工具类
 * 
 * 面试题：Collection 和 Collections的区别？
 * @author 14378
 *
 */
public class CollectionsTest {
	/*
	 * reverse(List):反转List中元素的顺序
	 * shuffle(List):对List集合元素进行随机排序
	 * sort(List):根据元素的自然顺序对指定List集合元素按升序排序
	 * sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
	 * swap():将指定list集合中i处元素和j处元素进行交换
	 * 
	 * Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
	 * Object max(Collection, Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素
	 * Object min(Collection):
	 * Object min(Collection, Comparator):
	 * int frequency(Collection, Object):返回指定集合中指定元素的出现次数
	 * void copy(List dest, List src):将src中的内容复制到dest中
	 * boolean replaceAll(List list, Object oldVal, Object newVal):使用新值替换List对象的所有旧值
	 */
	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(123);
		list.add(43);
		list.add(765);
		list.add(765);
		list.add(-97);
		list.add(0);
		
		System.out.println(list);//[123, 43, 765, 765, -97, 0]
		
		Collections.reverse(list);//
		System.out.println(list);//[0, -97, 765, 765, 43, 123]
		
		Collections.shuffle(list);
		System.out.println(list);//[43, 123, 0, -97, 765, 765]
		
		Collections.sort(list);
		System.out.println(list);//[-97, 0, 43, 123, 765, 765]
		
		Collections.swap(list, 1, 2);
		System.out.println(list);//[-97, 43, 0, 123, 765, 765]
		
		int frequency = Collections.frequency(list, 765);
		System.out.println(list);//[-97, 43, 0, 123, 765, 765]
		System.out.println(frequency);//2
		
		boolean replaceAll = Collections.replaceAll(list, 765, 789);
		System.out.println(replaceAll);//true
		System.out.println(list);//[-97, 43, 0, 123, 789, 789]
	}
	
	@Test
	public void test2() {
		List list = new ArrayList();
		list.add(123);
		list.add(43);
		list.add(765);
		list.add(-97);
		list.add(0);
		
//		List dest = new ArrayList();
//		Collections.copy(dest, list);//报异常：java.lang.IndexOutOfBoundsException: Source does not fit in dest
		//正确的：
		List dest = Arrays.asList(new Object[list.size()]);
		System.out.println(dest.size());//list.size();//5
		Collections.copy(dest, list);
		System.out.println(dest);//[123, 43, 765, -97, 0]
		
		/*
		 * Collections类中提供了多个synchronizedXxx()方法，
		 * 该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
		 */
		List list1 = Collections.synchronizedList(list);
	}
}
