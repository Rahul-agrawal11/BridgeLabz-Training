package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;

public class Student {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Rahul");
        jsonObject.put("age", 21);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("English");

        jsonObject.put("subjects", subjects);

        System.out.println(jsonObject.toString(2)); 
    }
}
