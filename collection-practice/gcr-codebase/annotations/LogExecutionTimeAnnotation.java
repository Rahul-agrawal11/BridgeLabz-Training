package annotations;

import java.lang.reflect.Method;

public class LogExecutionTimeAnnotation {

    @LogExecutionTime
    public void printName() {
        System.out.println("Name: Rahul Agrawal");
    }

    @LogExecutionTime
    public void printAge() {
        System.out.println("Age: 21");
    }

    public static void main(String[] args) throws Exception {

        LogExecutionTimeAnnotation obj =
                new LogExecutionTimeAnnotation();

        Method[] methods =
                LogExecutionTimeAnnotation.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();

                method.invoke(obj);

                long endTime = System.nanoTime();

                System.out.println(
                        "Method: " + method.getName() +
                        ", Execution Time (ns): " +
                        (endTime - startTime)
                );
            }
        }
    }
}
