package jsonData;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}

public class ListToJsonJackson {
	
	public static String convert(List<Person> list) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list);
	}

	public static void main(String[] args) throws Exception {
		List<Person> list = List.of(
				new Person("Rahul", 21),
				new Person("Sagar", 22));
		
		System.out.println(convert(list));
		
	}

}
