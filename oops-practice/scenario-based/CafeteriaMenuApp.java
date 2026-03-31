import java.util.Scanner;

class CafeteriaMenuApp {
	
	// Mrthod to display menu items
	public static void displayMenu(String[] items) {
		int index = 1;
		for (String item : items) {
			System.out.println(index++ + " " + item);
		}
	}
	
	// Method to take user chosen item index
	public static int getItemByIndex(String[] items, Scanner input) {
		System.out.println("Enter item index: ");
		int index = input.nextInt();
		return index-1;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] items = {"Maggi", "Pasta", "Coffee", "Tea", "Pizza", "Burger", "Gol-Gappe", "Momos", "Chaumean", "Kachori"};
		// Method call
		displayMenu(items);
		int index = getItemByIndex(items, input);
		System.out.println("User Choosed Dish: " + items[index]);
	}
}