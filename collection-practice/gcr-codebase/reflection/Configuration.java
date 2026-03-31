package reflection;

import java.lang.reflect.Field;

public class Configuration {

    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }

    public static void main(String[] args) {

        try {
            // Load class (FULLY QUALIFIED NAME)
            Class<?> cls = Class.forName("reflection.Configuration");

            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");

            // Disable access check
            field.setAccessible(true);

            // Modify static field (null because static)
            field.set(null, "LIVE_API_KEY_12345");

            // Read updated value
            System.out.println("Updated API_KEY: " + field.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
