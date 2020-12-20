package com.lbq.java.reflection;
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

	private String name;
	public int age;
	public int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@MyAnnotation(value="abc")
	private Person(String name) {
		this.name = name;
	}
	public Person() {
		System.out.println("Person()");
	}
	public void show() {
		System.out.println("你好，我是一个人");
	}
	
	@MyAnnotation
	private String showNation(String nation) {
		System.out.println("我的国籍是：" + nation);
		return nation;
	}
	
	public String display(String interests, int age) throws NullPointerException, ClassCastException {
		return interests + age;
	}
	@Override
	public void info() {
		System.out.println("我是一个人");
		
	}
	@Override
	public int compareTo(String o) {
		return 0;
	}
	
	private static void showDesc() {
		System.out.println("我是一个可爱的人");
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
}
