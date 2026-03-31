package annotations;
import java.util.ArrayList;

public class SuppressWarningTest {
    
    // Apply @SuppressWarnings at the method or variable level
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Raw type ArrayList (no generics)
        ArrayList list = new ArrayList();
        
        // This line normally causes an "unchecked call" warning
        list.add("Hello");
        list.add(100); // Mixing types
        
        System.out.println("List: " + list);
    }
}
