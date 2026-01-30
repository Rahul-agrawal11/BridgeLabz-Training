package com.junit;

import java.util.List;

public class ListManager {
	
	public boolean add(List<Integer> list, int element) {
		return list.add(element);
	}
	
	public boolean removeElement(List<Integer> list, int element) {
		return list.remove(Integer.valueOf(element));
	}
	
	public int getSize(List<Integer> list) {
		return list.size();
	}
}
