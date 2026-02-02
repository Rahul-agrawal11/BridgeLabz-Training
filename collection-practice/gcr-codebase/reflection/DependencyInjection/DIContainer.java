package reflection.DependencyInjection;

import java.lang.reflect.Field;

public class DIContainer {

    public static <T> T createObject(Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Object dependency = field.getType()
                            .getDeclaredConstructor()
                            .newInstance();
                    field.set(obj, dependency);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {

        Car car = DIContainer.createObject(Car.class);
        car.drive();
    }
}

