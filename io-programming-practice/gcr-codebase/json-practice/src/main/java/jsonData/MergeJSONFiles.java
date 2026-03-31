package jsonData;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class MergeJSONFiles {

    public static JSONObject merged(JSONObject obj1, JSONObject obj2) {

        JSONObject mergedObj = new JSONObject(obj1.toString());

        for (String key : obj2.keySet()) {
            mergedObj.put(key, obj2.get(key));
        }
        return mergedObj;
    }

    public static void main(String[] args) throws Exception {

        // Read JSON files as String
        String json1 = Files.readString(
                Path.of("src/main/resources/user.json")
        );

        String json2 = Files.readString(
                Path.of("src/main/resources/userInfo.json")
        );

        // Convert String → JSONObject
        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);

        // Merge
        JSONObject mergedObj = merged(obj1, obj2);

        System.out.println(mergedObj.toString(2));
    }
}
