// Task class holds task details
class Task {

    int taskId;
    String taskName;
    int priority;
    String dueDate;

    // Constructor
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

// Node class for Circular Linked List
class Node {

    Task task;     // Data part
    Node next;     // Pointer to next node

    // Constructor
    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Circular Linked List class
class CircularLinkedList {

    Node head = null;     // First task
    Node current = null;  // Used for task scheduling

    // Add task at beginning
    void insertAtBeginning(int taskId, String taskName, int priority, String dueDate) {

        Task t = new Task(taskId, taskName, priority, dueDate);
        Node node = new Node(t);

        // If list is empty
        if (head == null) {
            head = node;
            node.next = head; // Circular link
            current = head;
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != head) {
            temp = temp.next;
        }

        node.next = head;
        temp.next = node;
        head = node;
    }

    // Add task at end
    void insertAtEnd(int taskId, String taskName, int priority, String dueDate) {

        Task t = new Task(taskId, taskName, priority, dueDate);
        Node node = new Node(t);

        // If list is empty
        if (head == null) {
            head = node;
            node.next = head;
            current = head;
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = head;
    }

    // Add task at specific position (1-based index)
    void insertAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {

        if (position == 1) {
            insertAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task t = new Task(taskId, taskName, priority, dueDate);
        Node node = new Node(t);

        Node temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }

    // Remove task by Task ID
    void removeByTaskId(int taskId) {

        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        Node prev = null;

        // If head needs to be deleted
        if (head.task.taskId == taskId) {

            // Single node case
            if (head.next == head) {
                head = null;
                current = null;
                System.out.println("Task deleted");
                return;
            }

            // Move to last node
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = head.next;
            head = head.next;
            System.out.println("Task deleted");
            return;
        }

        // Traverse list
        temp = head;
        do {
            prev = temp;
            temp = temp.next;

            if (temp.task.taskId == taskId) {
                prev.next = temp.next;
                System.out.println("Task deleted");
                return;
            }

        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task and move to next task
    void viewCurrentTask() {

        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current.task);

        // Move to next task
        current = current.next;
    }

    // Search tasks by priority
    void searchByPriority(int priority) {

        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.task.priority == priority) {
                displayTask(temp.task);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Display all tasks starting from head
    void displayAllTasks() {

        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;

        System.out.println("\nAll Tasks:");
        do {
            displayTask(temp.task);
            temp = temp.next;
        } while (temp != head);
    }

    // Helper method to display task details
    void displayTask(Task t) {
        System.out.println(
            "Task ID: " + t.taskId +
            "\nTask Name: " + t.taskName +
            "\nPriority: " + t.priority +
            "\nDue Date: " + t.dueDate +
            "\n---------------------"
        );
    }
}

// Main class
class TaskScheduler {

    public static void main(String[] args) {

        CircularLinkedList scheduler = new CircularLinkedList();

        // Add tasks
        scheduler.insertAtEnd(1, "Design Module", 1, "10-02-2026");
        scheduler.insertAtEnd(2, "Implement Code", 2, "15-02-2026");
        scheduler.insertAtBeginning(3, "Requirement Analysis", 1, "05-02-2026");
        scheduler.insertAtPosition(2, 4, "Testing", 3, "20-02-2026");

        // Display all tasks
        scheduler.displayAllTasks();

        // View current task repeatedly (circular behavior)
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        // Search by priority
        scheduler.searchByPriority(1);

        // Remove a task
        scheduler.removeByTaskId(2);

        // Display updated list
        scheduler.displayAllTasks();
    }
}