package collections.queue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HospitalTriage {

    public static PriorityQueue<String> checkPatient(HashMap<String, Integer> patients) {

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> patients.get(b) - patients.get(a) // Max Priority
        );

        pq.addAll(patients.keySet());
        return pq;
    }

    public static void main(String[] args) {

        HashMap<String, Integer> patients = new HashMap<>();
        patients.put("John", 3);
        patients.put("Alice", 5);
        patients.put("Bob", 2);

        PriorityQueue<String> pq = checkPatient(patients);
        
        System.out.print("Order: ");
        while (!pq.isEmpty()) {
            String name = pq.poll();
            System.out.print(name + " ");
        }
    }
}
