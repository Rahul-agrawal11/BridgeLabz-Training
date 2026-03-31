package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList {
	
	public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> list) {
		int size = list.size();
		int start = 0;
		int end = size - 1;
		while (start < end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end,temp);
			start++;
			end--;
		}
		return list;
	}
	
	public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
		int size = list.size();
		int start = 0;
		int end = size - 1;
		while (start < end) {
			int temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end,temp);
			start++;
			end--;
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<>();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		arraylist.add(4);
		arraylist.add(5);
		arraylist.add(6);
		
		ArrayList<Integer> arraylist1 = reverseArrayList(arraylist); 
		System.out.println(arraylist1);
		
		LinkedList<Integer> linkedlist = new LinkedList<>();
		linkedlist.add(1);
		linkedlist.add(2);
		linkedlist.add(3);
		linkedlist.add(4);
		linkedlist.add(5);
		linkedlist.add(6);
		linkedlist.add(7);
		LinkedList<Integer> linkedlist1 = reverseLinkedList(linkedlist);
		System.out.println(linkedlist1);
	}

}
