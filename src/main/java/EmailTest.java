public class EmailTest {
    public static void main(String[] args) {
        EmailService service = (EmailService) EmailJdkProxy.getProxy(new EmailServiceImpl());
        service.send("gogogo");
    }
}
