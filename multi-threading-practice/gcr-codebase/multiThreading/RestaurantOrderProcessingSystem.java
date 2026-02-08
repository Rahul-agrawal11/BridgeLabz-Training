package multiThreading;

class Chef extends Thread {
    private String dish;
    private int totalTimeMs; // total cooking time in milliseconds

    public Chef(String chefName, String dish, int totalTimeMs) {
        super(chefName); // sets thread name
        this.dish = dish;
        this.totalTimeMs = totalTimeMs;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dish);

        int[] progressPoints = {25, 50, 75, 100};

        for (int progress : progressPoints) {
            try {
                // divide total time into 4 equal parts
                Thread.sleep(totalTimeMs / 4);
            } catch (InterruptedException e) {
                System.out.println(getName() + " got interrupted while preparing " + dish);
                return;
            }

            System.out.println(getName() + " preparing " + dish + ": " + progress + "% complete");
        }

        System.out.println(getName() + " finished preparing " + dish);
    }
}

public class RestaurantOrderProcessingSystem {
    public static void main(String[] args) throws InterruptedException {

        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        // Manager waits for all chefs to finish
        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("\nKitchen closed - All orders completed!");
    }
}
