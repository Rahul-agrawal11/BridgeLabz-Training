package ExceptionHandling;

public class ExceptionPropagationMethods {
	
	static int method1(int num, int divisor) {
		return num / divisor; // Exception occurs here
	}
	
	static int method2(int num, int divisor) {
		return method1(num, divisor); // Calls method1
	}

	public static void main(String[] args) {
		int num = 10;
		int divisor = 0;
		try {
			int result = method2(num, divisor); // Calls method2
			System.out.println("Result: " + result);
		} catch(ArithmeticException e) {
			System.out.println("Handled exception in main");
		}
	}
}
