package com.lbq.java.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * @author 14378
 *
 */
public class EmployeeTest {

	//问题一：使用自然排序
	@Test
	public void test1() {
		TreeSet set = new TreeSet();
		
		Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
		Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
		Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
		Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
		Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
//		Employee [name=guofucheng, age=44, birthday=MyDate [year=1987, month=5, day=9]]
//		Employee [name=liangzhaowei, age=21, birthday=MyDate [year=1978, month=12, day=4]]
//		Employee [name=liming, age=51, birthday=MyDate [year=1954, month=8, day=12]]
//		Employee [name=liudehua, age=55, birthday=MyDate [year=1965, month=5, day=4]]
//		Employee [name=zhangxueyou, age=43, birthday=MyDate [year=1987, month=5, day=4]]
	}
	//问题二：
	@Test
	public void test2() {
		TreeSet set = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee && o2 instanceof Employee) {
					Employee e1 = (Employee)o1;
					Employee e2 = (Employee)o2;
					
					MyDate b1 = e1.getBirthday();
					MyDate b2 = e2.getBirthday();
					
					return b1.compareTo(b2);
				}
				throw new RuntimeException("传入的数据类型不一致！");
			}
			
		});
		
		Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
		Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
		Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
		Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
		Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
//		Employee [name=liming, age=51, birthday=MyDate [year=1954, month=8, day=12]]
//		Employee [name=liudehua, age=55, birthday=MyDate [year=1965, month=5, day=4]]
//		Employee [name=liangzhaowei, age=21, birthday=MyDate [year=1978, month=12, day=4]]
//		Employee [name=zhangxueyou, age=43, birthday=MyDate [year=1987, month=5, day=4]]
//		Employee [name=guofucheng, age=44, birthday=MyDate [year=1987, month=5, day=9]]
	}
}
