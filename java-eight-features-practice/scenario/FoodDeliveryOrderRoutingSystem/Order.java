package scenario.FoodDeliveryOrderRoutingSystem;

class Order {
    private int orderId;
    private String customerName;
    private int customerLocation; 

    public Order(int orderId, String customerName, int customerLocation) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerLocation = customerLocation;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerLocation() {
        return customerLocation;
    }

    @Override
    public String toString() {
        return "Order{ID=" + orderId +
                ", Customer='" + customerName +
                "', Location=" + customerLocation + "}";
    }
}
