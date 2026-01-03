// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Chef class
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking food.");
    }
}

// Waiter class
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers.");
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Main class
class RestaurantManagement {
    public static void main(String[] args) {

        Worker chef = new Chef("Rahul", 101);
        Worker waiter = new Waiter("Amit", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}
