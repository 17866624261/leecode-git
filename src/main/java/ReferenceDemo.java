import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class MyObject {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("-------invoke finalize method");
    }
}

public class ReferenceDemo {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> PhantomReference = new PhantomReference<>(myObject, referenceQueue);

    }

    public static void softReference() {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------gc after内存够用" + softReference.get());
    }
    public static void weakReference(){
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("------gc before 内存够用："+weakReference.get());

        System.gc();
        System.out.println("------gc after 内存够用:"+weakReference.get());
    }
}
