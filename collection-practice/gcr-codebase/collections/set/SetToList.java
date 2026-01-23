package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetToList {

    public static List<Integer> sortedList(HashSet<Integer> set) {
        List<Integer> list = new ArrayList<>(set);

        // Bubble Sort
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        System.out.println("Sorted List: " + sortedList(set));
    }
}
