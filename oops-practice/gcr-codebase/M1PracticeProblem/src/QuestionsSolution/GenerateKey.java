package QuestionsSolution;

// import java.util.regex.*;
import java.util.Scanner;

public class GenerateKey {

	public String cleanAndInvert(String s) {

		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) % 2 != 0) {
				temp.append(Character.toLowerCase(s.charAt(i)));
			}
		}

		temp.reverse();

		StringBuilder key = new StringBuilder();

		for (int i = 0; i < temp.length(); i++) {

			if (i % 2 == 0) {
				key.append(Character.toUpperCase(temp.charAt(i)));
			} else {
				key.append(temp.charAt(i));
			}
		}

		return key.toString();
	}

	public static void main(String[] args) {
		GenerateKey g = new GenerateKey();
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < len; i++) {
			String s = sc.nextLine();

			if (s.length() < 6) {
				System.out.println("Invalid Input (length < 6)");
			} else {
				if (s.contains(" ")) {
					System.out.println("Invalid Input (contains space)");
				} else if (s.matches(".*\\d.*")) {
					System.out.println("Invalid Input (contains digits)");
				} else if (s.matches(".*[^a-zA-Z0-9].*")) {
					System.out.println("Invalid Input (contains special character)");
				} else if (s == null || s.trim().isEmpty()) {
					System.out.println("Invalid Input (empty string)");
				} else {
					String genKey = g.cleanAndInvert(s);
					if (genKey == null || genKey.trim().isEmpty()) {
						System.out.println("Invalid Input (empty string)");
					} else {
						System.out.println("The generated key is - " + genKey);
					}
				}
			}
		}
		sc.close();
	}
}
