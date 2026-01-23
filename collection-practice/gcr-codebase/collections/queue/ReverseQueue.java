package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	
	public static void reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		
		// Step 1: Move queue elements to stack
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		
		// Step 2: Move stack elements back to queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);

		System.out.println("Original Queue: " + queue);
		reverse(queue);
		System.out.println("Reversed Queue: " + queue);
	}
}
