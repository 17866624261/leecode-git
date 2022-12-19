public class JavaTest {
    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("非静态代码块");
    }

    public JavaTest() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        System.out.println("main,");
        JavaTest javaTest = new JavaTest();
    }
}
