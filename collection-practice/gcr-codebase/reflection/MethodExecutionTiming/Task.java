package reflection.MethodExecutionTiming;

class Task {
    public void runTask() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task completed");
    }
}

