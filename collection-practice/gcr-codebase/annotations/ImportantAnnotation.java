package annotations;

import java.lang.reflect.Method;

public class ImportantAnnotation {

    @ImportantMethod(level = "LOW")
    public void lowMethod() {
        System.out.println("I am Method1.");
    }

    @ImportantMethod(level = "MEDIUM")
    public void mediumMethod() {
        System.out.println("I am Method2.");
    }

    @ImportantMethod
    public void highMethod() {
        System.out.println("I am Method3.");
    }

    public static void main(String[] args) {

        Method[] methods = ImportantAnnotation.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod imp = method.getAnnotation(ImportantMethod.class);

                System.out.println(
                        "Method: " + method.getName() +
                        ", Level: " + imp.level()
                );
            }
        }
    }
}
