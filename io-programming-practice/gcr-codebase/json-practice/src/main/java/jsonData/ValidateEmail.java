package jsonData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.regex.*;

public class ValidateEmail {
	
	public static boolean validate(String email) {
		String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if(m.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String jsonText = "[{\"name\" : \"Rahul\", \"email\" : \"rahul@gmail.com\"}, {\"name\" : \"Amit\", \"email\" : \"amit123gmail.com\"}, {\"name\" : \"Neha\", \"email\" : \"neha123@gmail.com\"}]";
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = (ArrayNode)mapper.readTree(jsonText);
		
		for (JsonNode node : array) {
			if(validate(node.get("email").asText())) {
				System.out.println(node.get("email") + " valid");
			}
		}
	}

}
