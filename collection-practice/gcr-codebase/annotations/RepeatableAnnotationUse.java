package annotations;

import java.lang.reflect.Method;

public class RepeatableAnnotationUse {
	
	@BugReport(description = "NullPointerException issue")
	@BugReport(description = "Performance degradation")
	public void process() {
		System.out.println("Processing service...");
	}

	public static void main(String[] args) {
		Method method;
		try {
			method = RepeatableAnnotationUse.class.getMethod("process");
			BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
			
			for (BugReport bug : bugReports) {
	            System.out.println(bug.description());
	        }
		} catch (NoSuchMethodException | SecurityException e) {		
			e.printStackTrace();
		}
		
	}
}
