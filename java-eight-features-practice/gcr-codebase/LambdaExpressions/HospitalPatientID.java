package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class HospitalPatientID {

	public static void main(String[] args) {
		List<Integer> ids = Arrays.asList(101, 102, 103, 104, 105, 106);
		// Using println Method reference
		ids.forEach(System.out::println);
	}

}
