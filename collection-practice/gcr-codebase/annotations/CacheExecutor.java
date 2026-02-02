package annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheExecutor {
	
	@CacheResult
    public int expensiveCalculation(int n) {
        System.out.println("Executing expensive calculation...");
        return n * n;
    }

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object obj, String methodName, Object... args)
            throws Exception {

        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, int.class);

        if (!method.isAnnotationPresent(CacheResult.class)) {
            return method.invoke(obj, args);
        }

        String key = methodName + "_" + args[0];

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result...");
            return cache.get(key);
        }

        Object result = method.invoke(obj, args);
        cache.put(key, result);
        return result;
    }
    
    public static void main(String[] args) throws Exception {

    	CacheExecutor service = new CacheExecutor();

        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 5));
        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 5));
        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 10));
    }
}
