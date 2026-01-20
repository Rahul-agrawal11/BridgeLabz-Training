package scenario.TrafficManager;

public class TrafficManagerMain {
    public static void main(String[] args) {
        TrafficManager manager = new TrafficManager(3); // queue capacity 3

        manager.vehicleArrives("KA01AB1234");
        manager.vehicleArrives("KA02CD5678");
        manager.vehicleArrives("KA03EF9012");
        manager.vehicleArrives("KA04GH3456"); // queue overflow

        manager.showRoundabout();
        manager.showWaitingQueue();

        manager.vehicleExits("KA02CD5678");
        manager.showRoundabout();
        manager.showWaitingQueue();

        manager.vehicleExits("KA01AB1234");
        manager.vehicleExits("KA03EF9012");
        manager.vehicleExits("KA04GH3456"); // vehicle not on roundabout
    }
}

