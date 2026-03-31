package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public static void push(int x) {
        // Step 1: Add element to q2
        q2.add(x);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    public static int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Top operation
    public static int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    public static void main(String[] args) {

        push(1);
        push(2);
        push(3);

        System.out.println("Pop: " + pop()); // 3
        System.out.println("Top: " + top()); // 2
    }
}
