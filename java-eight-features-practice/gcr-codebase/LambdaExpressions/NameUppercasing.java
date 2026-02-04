package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class NameUppercasing {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("rahul", "deepa", "mahi", "sumit", "aditya");
		names.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
