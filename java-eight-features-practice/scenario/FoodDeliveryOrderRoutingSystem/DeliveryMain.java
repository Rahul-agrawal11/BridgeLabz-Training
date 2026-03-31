package scenario.FoodDeliveryOrderRoutingSystem;

public class DeliveryMain {
	public static void main(String[] args) {

		DeliveryService service = new DeliveryService();

		// Add Agents
		service.addAgent(new Agent(1, "Ravi", 10));
		service.addAgent(new Agent(2, "Amit", 25));
		service.addAgent(new Agent(3, "Neha", 15));

		// Place Orders
		service.placeOrder(new Order(101, "Rahul", 12));
		service.placeOrder(new Order(102, "Suresh", 30));
		service.placeOrder(new Order(103, "Pooja", 16));

		service.viewPendingOrders();
		service.viewAgents();

		try {
			System.out.println("\n" + service.assignNextOrder());
			System.out.println(service.assignNextOrder());
			System.out.println(service.assignNextOrder());
		} catch (NoAgentAvailableException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		service.viewActiveDeliveries();
		service.viewAgents();

		System.out.println("\nCancel Order 102: " + service.cancelOrder(102));

		service.viewActiveDeliveries();
		service.viewAgents();
	}
}
