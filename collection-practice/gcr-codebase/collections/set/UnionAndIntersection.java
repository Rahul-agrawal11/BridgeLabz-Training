package collections.set;

import java.util.HashSet;

public class UnionAndIntersection {

    // Returns Union of two sets
    public static HashSet<Integer> union(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> result = new HashSet<>();

        for (int i : set1) {
            result.add(i);
        }
        for (int i : set2) {
            result.add(i);
        }

        return result;
    }

    // Returns Intersection of two sets
    public static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> result = new HashSet<>();

        for (int i : set1) {
            if (set2.contains(i)) {
                result.add(i);
            }
        }

        return result;
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

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}
