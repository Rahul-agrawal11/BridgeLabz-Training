package annotations;

import java.lang.reflect.Method;

public class TaskManager {
	
	@TaskInfo(priority = 5, assignedTo = "Rahul")
	public void process() {
        System.out.println("Processing...");
    }

	public static void main(String[] args) throws Exception {
		Method method = TaskManager.class.getMethod("process");
		TaskInfo info = method.getAnnotation(TaskInfo.class);
		System.out.println(info.priority());
		System.out.println(info.assignedTo());
	}

}
