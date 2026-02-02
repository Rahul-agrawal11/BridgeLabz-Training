package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fully qualified class name(e.g., java.lang.String): ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            // -------- Fields --------
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(
                    Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getSimpleName() + " "
                    + field.getName()
                );
            }

            // -------- Constructors --------
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(
                    Modifier.toString(constructor.getModifiers()) + " "
                    + constructor.getName() + "()"
                );
            }

            // -------- Methods --------
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(
                    Modifier.toString(method.getModifiers()) + " "
                    + method.getReturnType().getSimpleName() + " "
                    + method.getName() + "()"
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }

        scanner.close();
    }
}
