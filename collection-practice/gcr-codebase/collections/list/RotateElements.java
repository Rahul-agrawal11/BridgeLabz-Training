package collections.list;

import java.util.ArrayList;
import java.util.List;

public class RotateElements {
	
	public static void rotateElements(List<Integer> list, int index) {
		for (int i = 0; i < index; i++) {
			int j = 0;
			int num = list.remove(j);
			list.add(num);
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<Integer> arraylist = new ArrayList<>();
		arraylist.add(10);
		arraylist.add(20);
		arraylist.add(30);
		arraylist.add(40);
		arraylist.add(50);
		arraylist.add(60);
		System.out.println(arraylist);
		rotateElements(arraylist, 3);
	}

}
