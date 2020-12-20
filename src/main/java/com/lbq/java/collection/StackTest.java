package com.lbq.java.collection;

import java.util.Stack;

import org.junit.Test;

public class StackTest {

	@Test
	public void test1() {
		Stack<String> stack = new Stack<>();
		String ele = stack.push("AA");
		System.out.println(ele);//AA
		ele = stack.push("BB");
		System.out.println(ele);//BB
		ele = stack.push("CC");
		System.out.println(ele);//CC
		ele = stack.push("DD");
		System.out.println(ele);//DD
		System.out.println(stack);//[AA, BB, CC, DD]
		
		System.out.println("*********************************");
		ele = stack.pop();
		System.out.println(ele);//DD
		System.out.println(stack);//[AA, BB, CC]
		
		System.out.println("*********************************");
		ele = stack.peek();
		System.out.println(ele);//CC
		System.out.println(stack);//[AA, BB, CC]
		
		int index = stack.search("BB");
		System.out.println(index);//2
		
		boolean empty = stack.empty();
		System.out.println(empty);//false
	}
}
