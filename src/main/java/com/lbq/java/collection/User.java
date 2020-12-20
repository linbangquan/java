package com.lbq.java.collection;

public class User implements Comparable{
	private String name;
	private int age;
	public User() {
	}
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
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
	
	@Override
	public int hashCode() {
		System.out.println("User hashCode() ...");
		int result = name != null ? name.hashCode() : 0;
		result = result * 31 + age;
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("User equals() ...");
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		if(age != user.age) return false;
		return name != null ? name.equals(user.name) : user.name == null;
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
//		User other = (User) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	//按照姓名从大到小排列，年龄从小到大排列
	@Override
	public int compareTo(Object o) {
		if(o instanceof User) {
			User user = (User) o;
//			return -this.name.compareTo(user.name);
			int compare = -this.name.compareTo(user.name);
			if(compare != 0) {
				return compare;
			}else {
				return Integer.compare(this.age, user.age);
			}
		}else {
			throw new RuntimeException("输入的类型不匹配");
		}
	}

}
