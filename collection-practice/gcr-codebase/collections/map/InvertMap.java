package collections.map;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvertMap {

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // If value not present, create new list
            invertedMap.putIfAbsent(value, new ArrayList<>());

            // Add key to the list
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);

        System.out.println(invertMap(map));
    }
}
