package reflection;

import java.lang.reflect.Field;

public class Person {
	private int age = 21;
	
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		Class<?> cls = person.getClass();
		
		// Access Private Field
		Field field = cls.getDeclaredField("age");
		field.setAccessible(true); // Allow access to private field
		
		// Get field value
		System.out.println("Old Age: " + field.get(person));
		
		// Modify field value
		field.set(person, 22);
		
		// Get modified value
        System.out.println("New Value: " + field.get(person));

	}
}
