package jsonData;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
	public String engineType;
	public String model;
	public Car(String engineType, String model) {
		super();
		this.engineType = engineType;
		this.model = model;
	}
}

public class ObjectToJSON {
	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Car car = new Car("Petrol", "1.2-litre Revotron(Tata)");
			
			// Convert Java Object to JSON String
			String jsonString = objectMapper.writeValueAsString(car);
			System.out.println(jsonString);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
