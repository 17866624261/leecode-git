import net.sf.cglib.proxy.Enhancer;

public class CglibFactory {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz.getSuperclass());
        enhancer.setCallback(new AliInterceptor());
        return enhancer.create();
    }
}
