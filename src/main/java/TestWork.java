import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class TestWork {
    public static void main(String[] args) throws InterruptedException {

//        LocalDateTime dt = LocalDateTime.now();
//        Thread.sleep(1000);
//        LocalDateTime start = LocalDateTime.of(2021, 9, 21, 0, 0, 0);
//        LocalDateTime start2 = LocalDateTime.now();
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        Date dt3 = new Date();
//
//        System.out.println(dt3);
//        System.out.println(start2.compareTo(dt));

//        String str = "16-:0,16+72:5,72+:10";
//        String[] splits = str.split(",");
//        for(String split:splits){
//            String[] ruleItem = split.split(":");
//            System.out.println(ruleItem[0].indexOf("-"));
//            System.out.println(split);
//        }
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
//        testPa(str1,str2,str3);
        String str4 = null;
        String res = Optional.ofNullable(str4).orElse("0");
//        System.out.println(res);

        ArrayList<Object> objects = new ArrayList<>();
        int[] arr = {7,9,8,2};
        Arrays.sort(arr);
        for (int i:arr
             ) {
            System.out.println(i);
        }

    }

    public static void testPa(String str1, String... strs) {
        System.out.println(str1);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
