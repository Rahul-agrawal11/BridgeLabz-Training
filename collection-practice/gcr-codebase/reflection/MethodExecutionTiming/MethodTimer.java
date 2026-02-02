package reflection.MethodExecutionTiming;

import java.lang.reflect.Method;

public class MethodTimer {

    public static void measure(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            long start = System.nanoTime();
            method.invoke(obj);
            long end = System.nanoTime();

            System.out.println("Execution Time: " + (end - start) / 1_000_000 + " ms");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {

        Task task = new Task();
        MethodTimer.measure(task, "runTask");
    }
}

