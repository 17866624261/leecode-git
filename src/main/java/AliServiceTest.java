public class AliServiceTest {
    public static void main(String[] args) {
        AliService proxy = (AliService)CglibFactory.getProxy(AliService.class);
        proxy.send("hello");
    }
}
