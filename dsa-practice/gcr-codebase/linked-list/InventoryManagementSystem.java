// Item class holds inventory item details
class Item {

    int itemId;
    String itemName;
    int quantity;
    double price;

    // Constructor
    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}

// Node class for Singly Linked List
class Node {

    Item item;     // Data
    Node next;     // Pointer to next node

    Node(Item item) {
        this.item = item;
        this.next = null;
    }
}

// Singly Linked List class
class InventoryLinkedList {

    Node head = null;

    // Insert item at beginning
    void insertAtBeginning(int id, String name, int qty, double price) {
        Item item = new Item(id, name, qty, price);
        Node node = new Node(item);

        node.next = head;
        head = node;
    }

    // Insert item at end
    void insertAtEnd(int id, String name, int qty, double price) {
        Item item = new Item(id, name, qty, price);
        Node node = new Node(item);

        if (head == null) {
            head = node;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    // Insert item at specific position (1-based index)
    void insertAtPosition(int position, int id, String name, int qty, double price) {

        if (position == 1) {
            insertAtBeginning(id, name, qty, price);
            return;
        }

        Item item = new Item(id, name, qty, price);
        Node node = new Node(item);

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        node.next = current.next;
        current.next = node;
    }

    // Remove item by Item ID
    void removeByItemId(int itemId) {

        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.item.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.item.itemId == itemId) {
                prev.next = curr.next;
                System.out.println("Item removed");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Item not found");
    }

    // Update quantity by Item ID
    void updateQuantity(int itemId, int newQty) {
        Node current = head;

        while (current != null) {
            if (current.item.itemId == itemId) {
                current.item.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            current = current.next;
        }

        System.out.println("Item not found");
    }

    // Search by Item ID
    void searchByItemId(int itemId) {
        Node current = head;

        while (current != null) {
            if (current.item.itemId == itemId) {
                displayItem(current.item);
                return;
            }
            current = current.next;
        }

        System.out.println("Item not found");
    }

    // Search by Item Name
    void searchByItemName(String name) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.item.itemName.equalsIgnoreCase(name)) {
                displayItem(current.item);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    // Calculate total inventory value
    void calculateTotalValue() {
        Node current = head;
        double total = 0;

        while (current != null) {
            total += current.item.price * current.item.quantity;
            current = current.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Display all items
    void displayInventory() {
        Node current = head;

        System.out.println("\nInventory Items:");
        while (current != null) {
            displayItem(current.item);
            current = current.next;
        }
    }

    // Helper to display item
    void displayItem(Item item) {
        System.out.println(
            "Item ID: " + item.itemId +
            "\nName: " + item.itemName +
            "\nQuantity: " + item.quantity +
            "\nPrice: ₹" + item.price +
            "\n----------------------"
        );
    }

    /* ===================== SORTING (MERGE SORT) ===================== */

    void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Node mergeSort(Node head, boolean asc, boolean byName) {
        if (head == null || head.next == null)
            return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head, asc, byName);
        Node right = mergeSort(nextOfMiddle, asc, byName);

        return sortedMerge(left, right, asc, byName);
    }

    private Node sortedMerge(Node a, Node b, boolean asc, boolean byName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;

        if (byName) {
            condition = asc
                ? a.item.itemName.compareToIgnoreCase(b.item.itemName) <= 0
                : a.item.itemName.compareToIgnoreCase(b.item.itemName) > 0;
        } else {
            condition = asc
                ? a.item.price <= b.item.price
                : a.item.price > b.item.price;
        }

        Node result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, asc, byName);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, asc, byName);
        }

        return result;
    }

    private Node getMiddle(Node head) {
        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// Main class
class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        // Add items
        inventory.insertAtEnd(101, "Laptop", 5, 60000);
        inventory.insertAtBeginning(102, "Mouse", 20, 500);
        inventory.insertAtEnd(103, "Keyboard", 10, 1500);
        inventory.insertAtPosition(2, 104, "Monitor", 7, 12000);

        // Display inventory
        inventory.displayInventory();

        // Search operations
        inventory.searchByItemId(103);
        inventory.searchByItemName("Mouse");

        // Update quantity
        inventory.updateQuantity(101, 8);

        // Calculate total value
        inventory.calculateTotalValue();

        // Sort by name (ascending)
        inventory.sortByName(true);
        inventory.displayInventory();

        // Sort by price (descending)
        inventory.sortByPrice(false);
        inventory.displayInventory();

        // Remove item
        inventory.removeByItemId(102);
        inventory.displayInventory();
    }
}
