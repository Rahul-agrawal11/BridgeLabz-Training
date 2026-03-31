package annotations;

import java.lang.reflect.Field;

public class JsonUser {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // not serialized

    public JsonUser(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
    
    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(obj);

                    json.append("\"")
                        .append(annotation.name())
                        .append("\":\"")
                        .append(value)
                        .append("\",");

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // Remove last comma
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }

        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) {

        JsonUser user = new JsonUser("Rahul", 21, "secret");

        System.out.println(JsonUser.toJson(user));
    }
}
