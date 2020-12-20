package com.lbq.java.collection;

import java.util.Objects;

public class Person2 {

	private String name;
	private int id;
	public Person2() {
	}
	public Person2(int id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("Person equals() ......");
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Person2 person = (Person2) o;
		if(id != person.id) return false;
		return name != null ? name.equals(person.name) : person.name == null; 
	}
	@Override
	public int hashCode() {
		System.out.println("Person hashCode() ......");
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
}
