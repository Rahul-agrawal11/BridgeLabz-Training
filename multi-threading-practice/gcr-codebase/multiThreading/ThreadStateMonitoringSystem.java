package multiThreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {

        // RUNNABLE state will be visible when thread starts executing
        System.out.println(getName() + " started computation at " + LocalTime.now());

        // Computation (RUNNABLE)
        long sum = 0;
        for (int i = 1; i <= 50_000_000; i++) {
            sum += i;
        }

        // Sleep (TIMED_WAITING)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted during sleep!");
        }

        // Small computation again
        for (int i = 1; i <= 10_000_000; i++) {
            sum += i;
        }

        System.out.println(getName() + " finished at " + LocalTime.now());
    }
}

class StateMonitor extends Thread {

    private Thread t1;
    private Thread t2;

    private Set<Thread.State> t1States = new LinkedHashSet<>();
    private Set<Thread.State> t2States = new LinkedHashSet<>();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public StateMonitor(Thread t1, Thread t2) {
        super("Monitor");
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run() {

        while (true) {
            Thread.State s1 = t1.getState();
            Thread.State s2 = t2.getState();

            // Store states for summary
            t1States.add(s1);
            t2States.add(s2);

            System.out.println("[Monitor] " + t1.getName() + " is in " + s1 +
                    " state at " + LocalTime.now().format(formatter));

            System.out.println("[Monitor] " + t2.getName() + " is in " + s2 +
                    " state at " + LocalTime.now().format(formatter));

            System.out.println("------------------------------------------------");

            // Stop when both are terminated
            if (s1 == Thread.State.TERMINATED && s2 == Thread.State.TERMINATED) {
                break;
            }

            // Check every 500ms
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Interrupted!");
                break;
            }
        }

        // Summary
        System.out.println("\n========= SUMMARY =========");
        System.out.println("Summary: " + t1.getName() + " went through " + t1States.size() + " states -> " + t1States);
        System.out.println("Summary: " + t2.getName() + " went through " + t2States.size() + " states -> " + t2States);
        System.out.println("===========================");
    }
}

public class ThreadStateMonitoringSystem {
    public static void main(String[] args) throws InterruptedException {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        // Before start => NEW
        System.out.println("Before start:");
        System.out.println(task1.getName() + " state: " + task1.getState());
        System.out.println(task2.getName() + " state: " + task2.getState());
        System.out.println("------------------------------------------------");

        // Monitor thread
        StateMonitor monitor = new StateMonitor(task1, task2);

        monitor.start();

        // Start tasks
        task1.start();
        task2.start();

        // Main waits for all
        task1.join();
        task2.join();
        monitor.join();

        System.out.println("\nMain thread finished execution!");
    }
}
