package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
	String cusName;
	double amount;
	public Order(String cusName, double amount) {
		this.cusName = cusName;
		this.amount = amount;
	}
	public String getCusName() {
		return cusName;
	}
	public double getAmount() {
		return amount;
	}
}

public class OrderRevenue {

	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(new Order("Rahul", 1200.0),
				new Order("Deepa", 1100.0),
				new Order("Mahi", 700.0),
				new Order("Deepa", 800.0),
				new Order("Rahul", 1500.0));
		
		Map<String, Double> bills = orders.stream().collect(Collectors.groupingBy(Order::getCusName, Collectors.summingDouble(Order::getAmount)));
		System.out.println(bills);
	}

}
