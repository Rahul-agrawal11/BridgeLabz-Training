package jsonData;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
	
	public static boolean isValidJSON(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(json);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String json = "{\"name\":\"Rahul\",\" age\":25}";
		System.out.println(isValidJSON(json) ? "Valid JSON" : "Invalid JSON");
	}

}
