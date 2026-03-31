// Student class holds student details
class Student {

    int rollNumber;
    String name;
    int age;
    char grade;

    // Constructor to initialize student data
    Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

// Node class represents one node of the linked list
class Node {

    Student student;   // Data part
    Node next;         // Reference to next node

    // Constructor to create a node with student data
    Node(Student student) {
        this.student = student;
        this.next = null;
    }
}

// Singly Linked List class
class SinglyLinkedList {

    Node head = null;  // Head of the linked list

    // Insert a student at the beginning
    void insertAtBeginning(int rollNumber, String name, int age, char grade) {
        Student s = new Student(rollNumber, name, age, grade);
        Node node = new Node(s);

        node.next = head; // New node points to current head
        head = node;      // Head updated to new node
    }

    // Insert a student at the end
    void insertAtEnd(int rollNumber, String name, int age, char grade) {
        Student s = new Student(rollNumber, name, age, grade);
        Node node = new Node(s);

        // If list is empty
        if (head == null) {
            head = node;
            return;
        }

        // Traverse till last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Attach new node at the end
        current.next = node;
    }

    // Insert a student at a specific position (1-based index)
    void insertAtPosition(int position, int rollNumber, String name, int age, char grade) {
        // If inserting at first position
        if (position == 1) {
            insertAtBeginning(rollNumber, name, age, grade);
            return;
        }

        Student s = new Student(rollNumber, name, age, grade);
        Node node = new Node(s);

        Node current = head;

        // Move to (position - 1)th node
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // If position is invalid
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        // Adjust pointers
        node.next = current.next;
        current.next = node;
    }

    // Delete a student by roll number
    void deleteByRollNumber(int rollNumber) {

        // If list is empty
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If head node needs to be deleted
        if (head.student.rollNumber == rollNumber) {
            head = head.next;
            System.out.println(rollNumber + " student deleted.");
            return;
        }

        Node previous = head;
        Node current = head.next;

        // Traverse list to find the student
        while (current != null) {
            if (current.student.rollNumber == rollNumber) {
                previous.next = current.next; // Bypass the node
                System.out.println(rollNumber + " student deleted.");
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Student not found");
    }

    // Search student by roll number
    void searchByRollNumber(int rollNumber) {
        Node current = head;

        while (current != null) {
            if (current.student.rollNumber == rollNumber) {
                System.out.println("Student Found:");
                System.out.println("Roll Number: " + current.student.rollNumber);
                System.out.println("Name: " + current.student.name);
                System.out.println("Age: " + current.student.age);
                System.out.println("Grade: " + current.student.grade);
                return;
            }
            current = current.next;
        }

        System.out.println("Student not found");
    }

    // Update grade using roll number
    void updateGradeByRollNumber(int rollNumber, char newGrade) {
        Node current = head;

        while (current != null) {
            if (current.student.rollNumber == rollNumber) {
                current.student.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            current = current.next;
        }

        System.out.println("Student not found");
    }

    // Display all student records
    void display() {
        Node current = head;

        while (current != null) {
            System.out.println(
                "Roll Number: " + current.student.rollNumber +
                "\nName: " + current.student.name +
                "\nAge: " + current.student.age +
                "\nGrade: " + current.student.grade +
                "\n---------------------"
            );
            current = current.next;
        }
    }
}

// Main class
class StudentRecordManagement {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Adding students
        list.insertAtBeginning(101, "Rahul", 21, 'A');
        list.insertAtBeginning(102, "Amit", 21, 'B');
        list.insertAtEnd(103, "Sagar", 21, 'A');
        list.insertAtPosition(2, 104, "Rohit", 22, 'A');

        // Display records
        list.display();

        // Delete student
        list.deleteByRollNumber(104);

        // Update grade
        list.updateGradeByRollNumber(103, 'B');

        // Display updated records
        list.display();
    }
}