public class SingletonTest {
    private volatile static SingletonTest singletonTest;

    private SingletonTest() {
    }

    public static SingletonTest single() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                singletonTest = new SingletonTest();
            }
        }
        return singletonTest;
    }
}
class TestSing{
    public static void main(String[] args) {
        System.out.println(SingletonTest.single());
    }
}
