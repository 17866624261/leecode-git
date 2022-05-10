public class StringFormat {
    public static void main(String[] args) {
        int age = 18;
        String name = "Yun";



        System.out.println(String.format("名字是:%s,年龄是:%s",name,age));
        System.out.println(System.currentTimeMillis()/1000/60/60/24/365);
    }
}
