package collections.set;

import java.util.HashSet;

public class CheckEqual {
	
	public static void checkEqual(HashSet<Integer> set1, HashSet<Integer> set2) {
		if(set1.equals(set2)) {
			System.out.println("Both are equal.");
		} else {
			System.out.println("Both are different.");
		}
	}

	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(4);
		set1.add(1);
		set1.add(2);
		set1.add(300000);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(300000);
		set2.add(2);
		set2.add(1);
		set2.add(4);
		System.out.println("Set1: " + set1 + "\nSet2: " + set2);
		checkEqual(set1, set2);
	}

}
