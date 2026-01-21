package review;


public class CheckAge {
	
	public static void check(int age) throws CustomException {
		
		if (age < 18) {
			throw new CustomException("Error: Age must be greater or equal than 18.");
		}
	}
	
	public static void main(String[] args) throws CustomException {
		
		try {
			int age = 17;
			CheckAge.check(age);
			System.out.println("Your age: " + age);
		}
		
		
		catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
