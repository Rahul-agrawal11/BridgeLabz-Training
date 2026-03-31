package annotations;

import java.lang.reflect.Method;

public class ToDoAnnotation {
	
	@Todo(task = "Backend", assignedTo = "Software Developer", priority = "HIGH")
	public void backend() {
		System.out.println("BAckend by Software Developer");
	}
	
	@Todo(task = "Frontend", assignedTo = "Web Developer")
	public void frontend() {
		System.out.println("Frontend by Web Developer");
	}
	
	@Todo(task = "Database", assignedTo = "Database Administrator", priority = "LOW")
	public void database() {
		System.out.println("Database by Database Administrator");
	}

	public static void main(String[] args) {
		try {
			Method[] methods = ToDoAnnotation.class.getDeclaredMethods();
			for (Method method : methods) {
				if(method.isAnnotationPresent(Todo.class)) {
					Todo todo = method.getAnnotation(Todo.class);
					System.out.println(
	                        "Method: " + method.getName() +
	                        ", Task: " + todo.task() + 
	                        ", AssignedTo: " + todo.assignedTo() + 
	                        ", Priority: " + todo.priority()
	                );
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
