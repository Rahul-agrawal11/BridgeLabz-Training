package scenario.FoodDeliveryOrderRoutingSystem;

import java.util.*;

class DeliveryService {

    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();

    // Active Deliveries (OrderId -> Agent)
    private Map<Integer, Agent> activeDeliveries = new HashMap<>();

    // Add Agent
    public boolean addAgent(Agent agent) {
        agents.add(agent);
        return true;
    }

    // Place Order
    public boolean placeOrder(Order order) {
        orderQueue.offer(order);
        return true;
    }

    // Assign next order FIFO to nearest available agent
    public String assignNextOrder() throws NoAgentAvailableException {

        if (orderQueue.isEmpty()) {
            return "No pending orders in queue!";
        }

        Order order = orderQueue.peek(); // check first FIFO order

        Agent nearestAgent = null;
        int minDistance = Integer.MAX_VALUE;

        for (Agent a : agents) {
            if (a.isAvailable()) {
                int distance = a.distanceFromCustomer(order.getCustomerLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestAgent = a;
                }
            }
        }

        if (nearestAgent == null) {
            throw new NoAgentAvailableException("No delivery agent is available right now!");
        }

        // Remove from queue and assign
        orderQueue.poll();

        nearestAgent.setAvailable(false);
        activeDeliveries.put(order.getOrderId(), nearestAgent);

        return "Assigned " + order + " to Agent: " + nearestAgent.getName()
                + " (Distance=" + minDistance + ")";
    }

    // Cancel Delivery (if already assigned)
    public boolean cancelOrder(int orderId) {

        if (activeDeliveries.containsKey(orderId)) {
            Agent agent = activeDeliveries.get(orderId);

            // free agent
            agent.setAvailable(true);

            // remove delivery
            activeDeliveries.remove(orderId);
            return true;
        }

        // If not assigned yet, try removing from queue
        Iterator<Order> it = orderQueue.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if (o.getOrderId() == orderId) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    // View Active Deliveries
    public void viewActiveDeliveries() {

        System.out.println("\n--- Active Deliveries ---");
        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries.");
            return;
        }

        for (Map.Entry<Integer, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println("OrderID: " + entry.getKey() + " -> Agent: " + entry.getValue().getName());
        }
    }

    // View Pending Orders
    public void viewPendingOrders() {
        System.out.println("\n--- Pending Orders Queue ---");
        for (Order o : orderQueue) {
            System.out.println(o);
        }
    }

    // View Agents
    public void viewAgents() {
        System.out.println("\n--- Agents ---");
        for (Agent a : agents) {
            System.out.println(a);
        }
    }
}