package scenario.FoodDeliveryOrderRoutingSystem;

class Agent {
    private int agentId;
    private String name;
    private int agentLocation;
    private boolean available;

    public Agent(int agentId, String name, int agentLocation) {
        this.agentId = agentId;
        this.name = name;
        this.agentLocation = agentLocation;
        this.available = true;
    }

    public int getAgentId() {
        return agentId;
    }

    public String getName() {
        return name;
    }

    public int getAgentLocation() {
        return agentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public int distanceFromCustomer(int customerLocation) {
        return Math.abs(this.agentLocation - customerLocation);
    }

    @Override
    public String toString() {
        return "Agent{ID=" + agentId +
                ", Name='" + name + "'" +
                ", Location=" + agentLocation +
                ", Available=" + available + "}";
    }
}
