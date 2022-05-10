import java.util.HashMap;
import java.util.Map;

public class MapTest2 {


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("User", new User());
        map.put("arr", new int[]{1, 2, 3});
        map.put("flag", true);
        map.put("str", "LongShine");
        map.put("year", 1996);
        System.out.println();
    }

    static class User {
        final String name = "Mart";
        final int age = 20;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

