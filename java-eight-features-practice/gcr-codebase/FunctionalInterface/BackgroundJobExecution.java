package FunctionalInterface;

public class BackgroundJobExecution {

	public static void main(String[] args) {
		Runnable task = () -> {
			System.out.println("Running in: " + Thread.currentThread().getName());
		};
		
		Thread t = new Thread(task);
        t.start();
	}

}
