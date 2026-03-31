package jsonData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

    public static void main(String[] args){

    	JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Rahul");
        jsonObject.put("age", 21);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("English");

        jsonObject.put("subjects", subjects);
        
        String xml = XML.toString(jsonObject, "student");
        System.out.println(xml);

    }
}
