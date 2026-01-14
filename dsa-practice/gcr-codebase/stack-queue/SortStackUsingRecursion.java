package stackAndQueue;

import java.util.Stack;

public class SortStackUsingRecursion {

    // Sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int element = stack.pop();
            sortStack(stack);
            sortedInsert(stack, element);
        }
    }

    // Insert element in sorted order
    public static void sortedInsert(Stack<Integer> stack, int element) {

        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(15);
        stack.push(25);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
