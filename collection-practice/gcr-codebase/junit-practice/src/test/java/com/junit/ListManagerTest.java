package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
	
	ListManager manager = new ListManager();
	List<Integer> list = new ArrayList<>();
	
	@Test
	void testAdd() {
		assertEquals(true, manager.add(list, 10));
		assertEquals(true, manager.add(list, 20));
	}
	
	
	@Test
	void testRemove() {
		assertEquals(true, manager.add(list, 10));
		assertEquals(true, manager.add(list, 20));
		assertEquals(true, manager.removeElement(list, 10));
	}
	
	@Test
	void testSize() {
		assertEquals(true, manager.add(list, 10));
		assertEquals(true, manager.add(list, 20));
		assertEquals(true, manager.removeElement(list, 10));
		assertEquals(1, manager.getSize(list));
	}
}
