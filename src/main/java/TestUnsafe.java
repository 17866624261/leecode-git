import sun.misc.Unsafe;

import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestUnsafe {
    public static void main(String[] args) {
//        reflectGetUnsafe();
        Unsafe unsafe = reflectGetUnsafe();
        int[] arr = new int[]{1, 2, 3};
        System.out.println(unsafe.arrayBaseOffset(arr.getClass()));
        System.out.println(unsafe.arrayIndexScale(arr.getClass()));
//        unsafe.compareAndSwapInt();
        HashMap<Object, Object> map = new HashMap<>();
        TreeMap<Person1,String> treeMap = new TreeMap<>((p1,p2)->p1.getAge().compareTo(p2.getAge()));
        map.put("a","v");
        map.put("a","s");
        int i = -100;
        System.out.println(i>>>1);
        Lock lock = new ReentrantLock();
        ThreadLocal<Person1> threadLocal = new InheritableThreadLocal<>();
        Person1 p1 = new Person1(10);
        Person1 p2 = new Person1(13);
        threadLocal.set(p2);
        threadLocal.set(p1);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(1,2));
        System.out.println(atomicInteger.get());
        System.out.println(threadLocal.get().getAge());
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private void memoryTest() {
        Unsafe unsafe = reflectGetUnsafe();

    }
}
class Person1{
    private Integer age;

    public Person1(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
