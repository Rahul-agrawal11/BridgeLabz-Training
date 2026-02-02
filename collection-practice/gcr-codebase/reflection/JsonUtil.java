package reflection;

import java.lang.reflect.Field;

class JsonUser {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class JsonUtil {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                json.append("\"")
                    .append(fields[i].getName())
                    .append("\":\"")
                    .append(fields[i].get(obj))
                    .append("\"");

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) {

        JsonUser user = new JsonUser();

        try {
            Field nameField = JsonUser.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(user, "Rahul");

            Field ageField = JsonUser.class.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(user, 21);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = JsonUtil.toJson(user);
        System.out.println(json);
    }

}

