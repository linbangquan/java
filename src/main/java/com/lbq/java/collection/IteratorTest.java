package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 	集合元素的遍历操作，使用迭代器Iterator接口
 * 	1.内部的方法：hasNext()和next()
 * 	2.集合对象每次调用iterator()方法都得到一个全新的迭代对象，默认游标都在集合的第一个元素之前。
 * 	3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove().
 * @author 14378
 *
 */
public class IteratorTest {

	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		
		Iterator iterator = coll.iterator();
		//方式一：
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		//报异常：java.util.NoSuchElementException
		//System.out.println(iterator.next());
		System.out.println("----------------------------------------------");
		//方式二：不推荐
		Iterator iterator2 = coll.iterator();
		for(int i = 0; i < coll.size(); i++) {
			System.out.println(iterator2.next());
		}
		System.out.println("----------------------------------------------");
		//方式三：推荐
		Iterator iterator3 = coll.iterator();
		//hasNext():判断是否还有下一个元素
		while(iterator3.hasNext()) {
			//next():1.指针下移，2.将下移以后的集合位置上的元素返回
			System.out.println(iterator3.next());
		}
	}
	
	@Test
	public void test2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		
		//错误方式一:
//		Iterator iterator = coll.iterator();
//		while((iterator.next()) != null) {
//			System.out.println(iterator.next());//java.util.NoSuchElementException
//		}
		
		System.out.println("----------------------------------------------");
		//错误方式二：
		//集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
		while(coll.iterator().hasNext()) {
			System.out.println(coll.iterator().next());
		}
	}
	//测试Iterator中的remove()
	//如果还没有调用next()或在上次调用next()方法之后已经调用了remove方法，再调用remove都会报IllegalStateException.
	@Test
	public void test3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);		
		System.out.println(coll);
		
		//删除集合中“Tom”
		Iterator iterator = coll.iterator();
		while(iterator.hasNext()) {
//			iterator.remove();//java.lang.IllegalStateException
			Object obj = iterator.next();
			if("Tom".equals(obj)) {
				iterator.remove();
				//iterator.remove();//java.lang.IllegalStateException
			}
		}
		System.out.println(coll);
	}
	
}
