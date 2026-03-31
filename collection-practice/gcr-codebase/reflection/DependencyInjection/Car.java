package reflection.DependencyInjection;

class Car {
    @Inject
    private Engine engine;

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
