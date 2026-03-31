package reflection.DynamicMethodInvoker;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvoker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        try {
        	Class<?> cls = Class.forName("reflection.DynamicMethodInvoker.MathOperations");

            // method name + parameter types
            Method method = cls.getMethod(methodName, int.class, int.class);

            // static method → object not required (null)
            Object result = method.invoke(null, a, b);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Invalid method name or error occurred");
        }

        sc.close();
    }
}

