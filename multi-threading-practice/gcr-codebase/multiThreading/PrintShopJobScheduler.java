package multiThreading;

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    private String getPriorityLabel() {
        if (priority >= 8) return "High Priority";
        else if (priority >= 5) return "Medium Priority";
        else return "Low Priority";
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + getPriorityLabel() + "] Printing " + jobName +
                    " - Page " + i + " of " + pages);

            try {
                Thread.sleep(100); // 100ms per page
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted!");
                return;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(jobName + " completed in " + (end - start) + " ms\n");
    }
}

public class PrintShopJobScheduler {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting print jobs...\n");

        long totalStart = System.currentTimeMillis();

        Thread t1 = new Thread(new PrintJob("Job1", 10, 5), "Job1-Thread");
        Thread t2 = new Thread(new PrintJob("Job2", 5, 8), "Job2-Thread");
        Thread t3 = new Thread(new PrintJob("Job3", 15, 3), "Job3-Thread");
        Thread t4 = new Thread(new PrintJob("Job4", 8, 6), "Job4-Thread");
        Thread t5 = new Thread(new PrintJob("Job5", 12, 7), "Job5-Thread");

        // Set thread priorities based on job priority
        t1.setPriority(5);  // Medium
        t2.setPriority(8);  // High
        t3.setPriority(3);  // Low
        t4.setPriority(6);  // Medium
        t5.setPriority(7);  // Medium-High

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Main waits for all jobs to complete
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long totalEnd = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (totalEnd - totalStart) + " ms");
    }
}
