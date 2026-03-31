package reflection.CustomLoggingProxy;

import java.lang.reflect.*;

public class LoggingProxy {

    public static Object createProxy(Object target) {

        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (proxy, method, args) -> {
                System.out.println("Calling method: " + method.getName());
                return method.invoke(target, args);
            }
        );
    }
    
    public static void main(String[] args) {

        Greeting greeting =
            (Greeting) LoggingProxy.createProxy(new GreetingImpl());

        greeting.sayHello("Rahul");
    }
}

