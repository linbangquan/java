package com.lbq.java.generic;

import java.util.List;

public class MapperTest {

	public static void main(String[] args) {
		Mapper<User> mapper = new Mapper<>();
		mapper.save("1001", new User(1001, 34, "周杰伦"));
		mapper.save("1002", new User(1002, 20, "昆凌"));
		mapper.save("1003", new User(1003, 25, "蔡依林"));
		
		mapper.update("1003", new User(1003, 30, "方文山"));
		
		mapper.delete("1002");
		
		List<User> list = mapper.list();
		System.out.println(list);
		list.forEach(System.out :: println);
	}
}
