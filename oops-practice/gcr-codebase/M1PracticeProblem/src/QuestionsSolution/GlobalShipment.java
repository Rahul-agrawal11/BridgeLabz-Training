package QuestionsSolution;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GlobalShipment {

	public boolean validateShipCode(String shipCode) {
		String regex = "^SHIP-(?!.*(\\d)\\1{3})[1-9][0-9]{5}$";
		return shipCode.matches(regex);
	}

	public boolean validateDate(String date) {
		try {
			LocalDate d = LocalDate.parse(date);
			return d.getYear() >= 2000 && d.getYear() <= 2099;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public boolean validateMode(String mode) {
		String regex = "AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT";
		return mode.matches(regex);
	}

	public boolean validateWeight(String weight) {
		if (!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$")) {
			return false;
		}
		double w = Double.parseDouble(weight);
		return w > 0 && w <= 999999.99;
	}

	public boolean validateDeliveryStatus(String status) {
		String regex = "DELIVERED|CANCELLED|IN_TRANSIT";
		return status.matches(regex);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GlobalShipment g = new GlobalShipment();

		int len = sc.nextInt();
		sc.nextLine();
		String[] res = new String[len];
		for (int i = 0; i < len; i++) {
			String data = sc.nextLine();
			String[] details = data.split("\\|");
			String code = details[0];
			String date = details[1];
			String mode = details[2];
			String weight = details[3];
			String status = details[4];

			if (g.validateShipCode(code) && g.validateDate(date) && g.validateMode(mode) && g.validateWeight(weight)
					&& g.validateDeliveryStatus(status)) {
				res[i] = "COMPLIANT RECORD";
			} else {
				res[i] = "NON-COMPLIANT RECORD";
			}
		}
		for (String s : res) {
			System.out.println(s);
		}
		sc.close();
	}

}
