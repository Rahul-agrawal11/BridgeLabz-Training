package jsonData;

import org.json.JSONObject;

public class MergeJson {
	
	public static JSONObject merged(JSONObject obj1, JSONObject obj2) {
		
		JSONObject mergedObj = new JSONObject(obj1.toString());
		
		for(String key : obj2.keySet()) {
			mergedObj.put(key, obj2.get(key));
		}
		return mergedObj;
	}

	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "Rahul");
		obj1.put("age", 21);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("email", "rahul@gmail.com");
		obj2.put("phone", "9876547891");
		
		JSONObject mergedObj = merged(obj1, obj2);
		System.out.println(mergedObj.toString(2));
	}

}
