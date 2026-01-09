// Node represents one text state
class Node {

    String text;
    Node prev;
    Node next;

    Node(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

// Text Editor using Doubly Linked List
class TextEditor {

    private Node head = null;
    private Node tail = null;
    private Node current = null;

    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new text state (typing or command)
    void addState(String newText) {

        Node node = new Node(newText);

        // If editor is empty
        if (head == null) {
            head = tail = current = node;
            size = 1;
            return;
        }

        // Remove redo history
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countNodes();
        }

        // Add new node at end
        tail.next = node;
        node.prev = tail;
        tail = node;
        current = node;
        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }

        current = current.prev;
        System.out.println("Undo performed");
    }

    // Redo operation
    void redo() {

        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }

        current = current.next;
        System.out.println("Redo performed");
    }

    // Display current text
    void displayCurrentState() {

        if (current == null) {
            System.out.println("Editor is empty");
        } else {
            System.out.println("Current Text: \"" + current.text + "\"");
        }
    }

    // Count nodes (used after clearing redo history)
    private int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display full history (optional – for understanding)
    void displayHistory() {

        Node temp = head;
        System.out.print("History: ");

        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.text + "] ");
            else
                System.out.print(temp.text + " ");

            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class
class UndoRedoEditor {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        // Typing text
        editor.addState("H");
        editor.addState("He");
        editor.addState("Hel");
        editor.addState("Hell");
        editor.addState("Hello");

        editor.displayCurrentState();
        editor.displayHistory();

        // Undo actions
        editor.undo();
        editor.undo();
        editor.displayCurrentState();
        editor.displayHistory();

        // Redo action
        editor.redo();
        editor.displayCurrentState();
        editor.displayHistory();

        // New typing clears redo history
        editor.addState("Hello World");
        editor.displayCurrentState();
        editor.displayHistory();
    }
}
