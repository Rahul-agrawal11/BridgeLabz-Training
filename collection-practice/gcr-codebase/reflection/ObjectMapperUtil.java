package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(obj, entry.getValue());
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("name", "Rahul");
        properties.put("age", 21);

        User user = ObjectMapperUtil.toObject(User.class, properties);
        System.out.println(user);
    }
}