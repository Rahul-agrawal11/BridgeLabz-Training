package collections.list;

import java.util.LinkedList;

public class NthElementFromTheEnd {
	
	public static void findElement(LinkedList<Character> list, int index) {
		System.out.print("Element at index " + index + " from end is: ");
		System.out.println(list.get(list.size() - index));
	}

	public static void main(String[] args) {
		LinkedList<Character> linkedlist = new LinkedList<>();
		linkedlist.add('A');
		linkedlist.add('B');
		linkedlist.add('C');
		linkedlist.add('D');
		linkedlist.add('E');
		linkedlist.add('F');
		linkedlist.add('G');
		System.out.println("List: " + linkedlist);
		findElement(linkedlist, 3);
	}

}
