package jsonData;

import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class ReadJsonFile {

	public static void main(String[] args) throws Exception{
		String jsonText = Files.readString(Path.of("src/main/resources/user.json"));
		JSONObject json = new JSONObject(jsonText);
		System.out.println("Name: " + json.getString("name"));
		System.out.println("Email: " + json.getString("email"));
	}

}
