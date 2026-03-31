package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
	String type;
	double amount;
	public Claim(String type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
}

public class ClaimAverage {

	public static void main(String[] args) {
		List<Claim> claims = new ArrayList<>();
		claims.add(new Claim("Health", 12000));
		claims.add(new Claim("Car", 8000));
		claims.add(new Claim("Health", 15000));
		claims.add(new Claim("Car", 10000));
		claims.add(new Claim("Life", 50000));
		claims.add(new Claim("Life", 30000));
		
		Map<String, Double> avgByType = claims.stream().collect(Collectors.groupingBy(Claim::getType, Collectors.averagingDouble(Claim::getAmount)));
		avgByType.forEach((type, avg) -> System.out.println(type + " Average: " + avg));
	}

}
