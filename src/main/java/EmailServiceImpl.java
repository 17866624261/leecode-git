public class EmailServiceImpl implements EmailService{

    @Override
    public String send(String word) {
        System.out.println("send message:"+word);
        return word;
    }
}
