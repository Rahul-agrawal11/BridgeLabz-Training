package collections.set;

import java.util.HashSet;

public class SymmetricDifference {
	
	public static void symmetricDiff(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i : set1) {
			if(!set2.contains(i)) {
				set.add(i);
			}
		}
		
		for(int i : set2) {
			if(!set1.contains(i)) {
				set.add(i);
			}
		}
		
		System.out.println("Symmetric Difference: " + set);
	}

	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        symmetricDiff(set1, set2);
	}

}
