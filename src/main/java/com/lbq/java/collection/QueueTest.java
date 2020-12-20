package com.lbq.java.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test1() {
		Queue<String> queue = new ArrayBlockingQueue<>(10);
		boolean flag = queue.add("AA");
		System.out.println(flag);//true
		flag = queue.add("BB");
		System.out.println(flag);//true
		flag = queue.add("CC");
		System.out.println(flag);//true
		flag = queue.add("DD");
		System.out.println(flag);//true
		System.out.println(queue);//[AA, BB, CC, DD]
		
		flag = queue.offer("EE");
		System.out.println(flag);//true,加锁了
		System.out.println(queue);//[AA, BB, CC, DD, EE]
		
		String ele = queue.poll();
		System.out.println(ele);//AA
		System.out.println(queue);//[BB, CC, DD, EE]
		
		ele = queue.remove();
		System.out.println(ele);//BB
		System.out.println(queue);//[CC, DD, EE]
		
		ele = queue.peek();
		System.out.println(ele);//CC
		System.out.println(queue);//[CC, DD, EE]
		
		ele = queue.element();
		System.out.println(ele);//CC
		System.out.println(queue);//[CC, DD, EE]
	}
}
