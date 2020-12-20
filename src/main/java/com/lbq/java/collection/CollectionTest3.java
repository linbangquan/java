package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CollectionTest3 {

	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(343);
		coll.add(343);
		
		coll.forEach(System.out::println);
	}
	
	public static List duplicateList(List list) {
		HashSet set = new HashSet();
		set.addAll(list);
		return new ArrayList(set);
	}
	
	@Test
	public void test2() {
		List list = new ArrayList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(2));
		list.add(new Integer(4));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(5));
		
		List list2 = duplicateList(list);
		for(Object integer : list2) {
			System.out.println(integer);
		}
	}
	
	@Test
	public void test3() {
		HashSet set = new HashSet();
		Person2 p1 = new Person2(1001, "AA");
		Person2 p2 = new Person2(1002, "BB");
		
		set.add(p1);
		set.add(p2);
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=AA, id=1001]]
		
		p1.setName("CC");
		set.remove(p1);
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=AA, id=1001]]
		
		set.add(new Person2(1001, "CC"));
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=CC, id=1001], Person [name=CC, id=1001]]
		set.add(new Person2(1001, "AA"));
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=CC, id=1001], Person [name=CC, id=1001], Person [name=AA, id=1001]]
		
		set.remove(new Person2(1001, "CC"));
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=CC, id=1001], Person [name=AA, id=1001]]
		
		set.remove(new Person2(1001, "AA"));
		System.out.println(set);//[Person [name=BB, id=1002], Person [name=CC, id=1001]]
	}
}
