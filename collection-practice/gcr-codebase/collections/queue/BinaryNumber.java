package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumber {

    public static Queue<String> generateBinary(int n) {
        Queue<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateBinary(n));
    }
}