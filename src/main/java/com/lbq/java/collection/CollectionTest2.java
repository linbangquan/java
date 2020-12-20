package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * Collection接口中声明的方法的测试
 * 
 * 	结论：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 * @author 14378
 *
 */
public class CollectionTest2 {
	
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
//		Person p = new Person("Jerry", 20);
//		coll.add(p);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);
		//1.contains(Object obj):判断当前集合中是否包含obj
		//我们在判断时会调用obj对象所在类的equals().
		boolean contains = coll.contains(123);
		System.out.println(contains);//true
		System.out.println(coll.contains(new String("Tom")));//true
//		System.out.println(coll.contains(p));//true
		System.out.println(coll.contains(new Person("Jerry", 20)));//false-->true(重写equals方法后变成true)
		
		//2.containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合中。
		Collection coll1 = Arrays.asList(123,4567);
		System.out.println(coll.containsAll(coll1));
		
	}
	
	@Test
	public void test2() {
		//3.remove(Object obj):从当前集合中移除obj元素。
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);//[123, 456, Person [name=Jerry, age=20], Tom, false]
		
		coll.remove(123);
		System.out.println(coll);//[456, Person [name=Jerry, age=20], Tom, false]
		
		coll.remove(new Person("Jerry", 20));
		System.out.println(coll);//[456, Tom, false]
		
		//4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
		Collection coll1 = Arrays.asList(123, 456, false);
		boolean removeAll = coll.removeAll(coll1);
		System.out.println(removeAll+","+coll);//true,[Tom]
	}
	
	@Test
	public void test3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		//5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//		Collection coll1 = Arrays.asList(123, 456, 789);
//		boolean retainAll = coll.retainAll(coll1);
//		System.out.println(retainAll + "," + coll);//true,[123, 456]
		
		//6.equals(Object obj):要想返回true,需要当前集合和形参集合的元素都相同。
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add(456);
		coll2.add(new Person("Jerry", 20));
		coll2.add(new String("Tom"));
		coll2.add(false);
		System.out.println(coll2);
		System.out.println(coll.equals(coll2));
	}
	
	@Test
	public void test4() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		
		//7.hashCode():返回当前对象的哈希值
		System.out.println(coll.hashCode());
		
		//8.集合 --->数组：toArray()
		Object[] arr = coll.toArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//拓展：数组 ---->集合：调用Arrays类的静态方法asList()
		List<String> list = Arrays.asList(new String[] {"AA", "BB", "CC"});
		System.out.println(list);//[AA, BB, CC]
		
		List arr1 = Arrays.asList(new int[] {123, 456});
		System.out.println(arr1);//[[I@41906a77]
		System.out.println(arr1.size());//1
		
		List arr2 = Arrays.asList(new Integer[] {123, 456});
		System.out.println(arr2);//[123, 456]
		System.out.println(arr2.size());//2
		
		//9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
	}
	
	public void test5() {
		
//		Collection coll = new ArrayList();
//		coll.add(e);
//		coll.addAll(c);
//		coll.clear();
//		coll.contains(o);
//		coll.containsAll(c);
//		coll.equals(o);
//		coll.hashCode();
//		coll.isEmpty();
//		coll.iterator();
//		coll.parallelStream();
//		coll.remove(o);
//		coll.removeAll(c);
//		coll.removeIf(filter);
//		coll.retainAll(c);
//		coll.size();
//		coll.spliterator();
//		coll.stream();
//		coll.toArray();
//		coll.toArray(a);
		
	}
}
