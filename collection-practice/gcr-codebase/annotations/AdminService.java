package annotations;

import java.lang.reflect.Method;

@RoleAllowed("ADMIN")
public class AdminService {

    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }
    
    // Simulated logged-in user role
    static String currentUserRole = "ADMIN"; // try changing to "USER"

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Class<?> clazz = service.getClass();

        // Check if class has @RoleAllowed
        if (clazz.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed =
                    clazz.getAnnotation(RoleAllowed.class);

            String allowedRole = roleAllowed.value();

            if (!currentUserRole.equals(allowedRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // If role matches → invoke method
        Method method = clazz.getMethod("deleteUser");
        method.invoke(service);
    }
}
