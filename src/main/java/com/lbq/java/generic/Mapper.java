package com.lbq.java.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
 * @author 14378
 *
 */
public class Mapper<T> {

	private Map<String, T> map = new HashMap<>();
	
	public void save(String id, T entity) {
		map.put(id, entity);
	}
	
	public T get(String id) {
		return map.get(id);
	}
	
	public void update(String id, T entity) {
		if(map.containsKey(id)) {
			map.put(id, entity);
		}
	}
	
	public List<T> list(){
		//错误的：
//		Collection<T> values = map.values();
//		return (List<T>) values;//Exception in thread "main" java.lang.ClassCastException: java.util.HashMap$Values cannot be cast to java.util.List
		//正确的：
		ArrayList<T> list = new ArrayList<>();
		Collection<T> values = map.values();
		for(T t : values) {
			list.add(t);
		}
		return list;
	}
	
	public void delete(String id) {
		map.remove(id);
	}
}
