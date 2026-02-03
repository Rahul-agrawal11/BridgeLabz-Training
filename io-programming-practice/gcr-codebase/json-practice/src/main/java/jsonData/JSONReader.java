package jsonData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class JSONReader {

	public static void main(String[] args) throws IOException {
		String jsonText = Files.readString(Path.of("src/main/resources/user.json"));
		JSONObject json = new JSONObject(jsonText);
		
		for (String key : json.keySet()) {
			System.out.println(key + " : " + json.get(key));
		}
	}

}
