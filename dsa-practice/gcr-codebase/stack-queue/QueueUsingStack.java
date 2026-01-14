package stackAndQueue;

import java.util.Stack;
import java.util.Scanner;

public class QueueUsingStack {
	
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	// Enqueue Elements
	public void enqueue(int data) {
		s1.push(data);
		System.out.println(data + " Enqueued.");
	}
	
	// Dequeue Elements
	public int dequeue() {
		if (s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		
		if (s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	// Display Queue
	public void display() {

	    // Elements in s2 are already in correct queue order
	    for (int i = s2.size() - 1; i >= 0; i--) {
	        System.out.print(s2.get(i) + " ");
	    }

	    // Elements in s1 are in reverse order
	    for (int i = 0; i < s1.size(); i++) {
	        System.out.print(s1.get(i) + " ");
	    }
	    System.out.println();
	}

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		QueueUsingStack queue = new QueueUsingStack();
		
		int choice;
		
		do {
		    System.out.println("1. Enqueue Element");
		    System.out.println("2. Dequeue Element");
		    System.out.println("3. Display Queue");
		    System.out.println("0. Exit");

		    System.out.print("Enter Choice: ");
		    choice = input.nextInt();

		    if (choice == 1) {
		        System.out.print("Enter element: ");
		        int data = input.nextInt();
		        queue.enqueue(data);

		    } else if (choice == 2) {
		        int de = queue.dequeue();
		        if (de != -1) {
		            System.out.println(de + " dequeued.");
		        }

		    } else if (choice == 3) {
		        System.out.print("Queue: ");
		        queue.display();

		    } else if (choice == 0) {
		        System.out.println("Exiting...");

		    } else {
		        System.out.println("Invalid choice!");
		    }

		} while (choice != 0);

		
	}
}
