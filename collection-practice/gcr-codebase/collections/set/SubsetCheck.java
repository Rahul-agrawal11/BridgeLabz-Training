package collections.set;
import java.util.HashSet;
import java.util.Set;

public class SubsetCheck {

    public static boolean isSubset(int[] set1, int[] set2) {
        Set<Integer> mainSet = new HashSet<>();

        // Add all elements of set2 to HashSet
        for (int num : set2) {
            mainSet.add(num);
        }

        // Check each element of set1
        for (int num : set1) {
            if (!mainSet.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] set1 = {2, 3};
        int[] set2 = {1, 2, 3, 4};

        System.out.println(isSubset(set1, set2)); // true
    }
}
