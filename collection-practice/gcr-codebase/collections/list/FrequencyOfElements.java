package collections.list;

import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyOfElements {
	
	public static HashMap<String, Integer> checkFreq(ArrayList<String> list) {
		HashMap<String, Integer> freq = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			int count = 0;
			String value = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (value == list.get(j)) {
					count++;
				}
			}
			freq.put(value, count);
		}
		return freq;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("apple");
		list.add("orange");
		
		HashMap<String, Integer> freq = checkFreq(list);
		System.out.println(freq);
	}

}
