package annotations;

// Parent class
class Animal {
    void makeSound() {
        System.out.println("Animal makes sound.");
    }
}

// Child class
class Dog extends Animal {
    // @Override ensures the method overrides a superclass method
    @Override
    void makeSound() {
        System.out.println("Dog barks.");
    }
}

public class OverrideAnnotation {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // Calls the overridden method in Dog
    }
}
