package com.lbq.java.compare;

public class Goods implements Comparable<Goods> {

	private String name;
	private double price;
	
	public Goods() {
		
	}

	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
	
	//指明商品比较大小的方式：按照价格从低到高排序，再按照产品名称从高到低排序
	@Override
	public int compareTo(Goods goods) {
//		System.out.println("******************");
//		//方式一：
//		if(this.price > goods.price) {
//			return 1;
//		}else if(this.price < goods.price){
//			return -1;
//		}else {
////			return 0;
//			return -this.name.compareTo(goods.name);
//		}
		
		//方式二：
		int result = Double.compare(this.price, goods.price);
		if(result == 0) {
			return -this.name.compareTo(goods.name);
		}else {
			return result;
		}
	}
}
