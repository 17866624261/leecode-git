import java.lang.reflect.Proxy;

public class EmailJdkProxy {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new EmailInvocation(target));
    }
}
