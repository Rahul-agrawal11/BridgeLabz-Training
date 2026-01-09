// Process class holds process details
class Process {

    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

// Node class for Circular Linked List
class Node {

    Process process;
    Node next;

    Node(Process process) {
        this.process = process;
        this.next = null;
    }
}

// Circular Linked List based Round Robin Scheduler
class RoundRobinScheduler {

    Node head = null;
    Node tail = null;
    int timeQuantum;

    int completedProcesses = 0;
    double totalWaitingTime = 0;
    double totalTurnaroundTime = 0;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    void addProcess(int pid, int burstTime, int priority) {

        Process p = new Process(pid, burstTime, priority);
        Node node = new Node(p);

        if (head == null) {
            head = tail = node;
            tail.next = head; // circular link
        } else {
            tail.next = node;
            tail = node;
            tail.next = head; // maintain circular nature
        }
    }

    // Remove process from circular list
    void removeProcess(Node prev, Node current) {

        // Only one process
        if (current == head && current == tail) {
            head = tail = null;
            return;
        }

        // Removing head
        if (current == head) {
            head = head.next;
            tail.next = head;
        }
        // Removing tail
        else if (current == tail) {
            tail = prev;
            tail.next = head;
        }
        // Removing middle node
        else {
            prev.next = current.next;
        }
    }

    // Round Robin Scheduling
    void schedule() {

        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        Node current = head;
        Node prev = tail;
        int currentTime = 0;

        System.out.println("\n--- Round Robin Scheduling Started ---");

        while (head != null) {

            Process p = current.process;

            int executedTime = Math.min(timeQuantum, p.remainingTime);
            p.remainingTime -= executedTime;
            currentTime += executedTime;

            System.out.println(
                "Process P" + p.processId +
                " executed for " + executedTime +
                " units | Remaining: " + p.remainingTime
            );

            // Update waiting time of other processes
            Node temp = head;
            do {
                if (temp.process != p && temp.process.remainingTime > 0) {
                    temp.process.waitingTime += executedTime;
                }
                temp = temp.next;
            } while (temp != head);

            // If process completed
            if (p.remainingTime == 0) {

                p.turnaroundTime = currentTime;

                totalWaitingTime += p.waitingTime;
                totalTurnaroundTime += p.turnaroundTime;
                completedProcesses++;

                System.out.println("Process P" + p.processId + " completed");

                Node nextNode = current.next;
                removeProcess(prev, current);

                if (head == null)
                    break;

                current = nextNode;
                displayQueue();
                continue;
            }

            prev = current;
            current = current.next;
            displayQueue();
        }

        // Display averages
        System.out.println("\n--- Scheduling Completed ---");
        System.out.println("Average Waiting Time: " +
                (totalWaitingTime / completedProcesses));
        System.out.println("Average Turnaround Time: " +
                (totalTurnaroundTime / completedProcesses));
    }

    // Display queue
    void displayQueue() {

        if (head == null) {
            System.out.println("Queue empty");
            return;
        }

        Node temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print(
                "P" + temp.process.processId +
                "(" + temp.process.remainingTime + ") -> "
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}

// Main class
public class RoundRobinScheduling {

    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        scheduler.schedule();
    }
}