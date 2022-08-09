import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public class TestCopy<T> {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String s1 = "abc";
        String s2 = "abc";
        testRever(s1);
        System.out.println(s1);
        List<String> list = new ArrayList<>();
//        if (list instanceof List<String>){
//
//        }

        Class<?> targetClass = Class.forName("TargetObject");
        TargetObject targetObject = (TargetObject)targetClass.newInstance();
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method.getName());
        }
        Method method = targetClass.getDeclaredMethod("publicMethod", String.class);
        method.invoke(targetObject,"Hello JavaGuide");
    }

    public static <T> T backT(T t) {
        return t;
    }

    public static void testRever(String... s) {
        s[0] = "ace";
    }
}

class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
