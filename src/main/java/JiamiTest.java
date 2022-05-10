public class JiamiTest {
    public static void main(String[] args) {
        try {

            String username = "2EC80AEBCA850EA7";
            if (username != null) {
                System.out.println(DesEncryptUtil.decrypt(username, "kEHrDooxWHCWtfeSxvDvgqZq"));
            }
    }catch (Exception e){
        e.printStackTrace();
        }
    }
}
