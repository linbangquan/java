package com.lbq.java.optional;

public class Girl {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Girl() {
	}

	public Girl(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}
}
