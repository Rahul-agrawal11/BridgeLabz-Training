package jsonData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJsonJackson {

	public static void main(String[] args) throws Exception {
		String jsonText = "[{\"name\" : \"Rahul\", \"age\" : 21}, {\"name\" : \"Amit\", \"age\" : 28}, {\"name\" : \"Neha\", \"age\" : 30}]";
		 
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = (ArrayNode)mapper.readTree(jsonText);
		
		ArrayNode filtered = mapper.createArrayNode();
		
		for (JsonNode node : array) {
			if (node.get("age").asInt() > 25) {
				filtered.add(node);
			}
		}
		
		System.out.println(filtered);
	}

}
