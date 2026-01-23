package collections.list;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
	
	public static void removeDuplicates(List<Integer> list) {
		
		int i = 0;
		while (i < list.size()) {
			for (int index = i+1; index < list.size(); index++) {
				if (list.get(i) == list.get(index)) {
					list.remove(index);
				}
			}
			i++;
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		removeDuplicates(list);
	}

}
