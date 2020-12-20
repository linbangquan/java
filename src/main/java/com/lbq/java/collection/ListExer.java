package com.lbq.java.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListExer {
	
	/**
	 * 区分List中remove(int index)和remove(Object obj)
	 */
	@Test
	public void testListRemove() {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		updateList(list);
		System.out.println(list);
	}

	private void updateList(List list) {
//		list.remove(2);//remove(int index)
		list.remove(new Integer(2));//remove(Object o)
		
	}
}
