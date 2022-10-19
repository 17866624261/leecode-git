import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

public class OptionalDemo {
    private static final String INYES = "defaultname";
    public static void main(String[] args) {
        User user = new User("lisi", 12, "男");
        User user2 = null;
        Optional<User> userOptional = Optional.ofNullable(user);
        Optional<User> userOptional2 = Optional.ofNullable(user2);
        if (userOptional.isPresent()) {
            System.out.println("存在");
        } else {
            System.out.println("为空");
        }
        if (userOptional2.isPresent()) {
            System.out.println("存在");
        } else {
            System.out.println("为空");
        }
        System.out.println(userOptional);
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println("=================");
        User user3 = null;
        User result = Optional.ofNullable(user3).orElse(user);
        User result2 = Optional.ofNullable(user3).orElseGet(() -> user);
        System.out.println(result);
        System.out.println(result2);
        System.out.println("=================");
        User nw = new User("liuqi", 28, "女");
        System.out.println("是用orElse");
        User nw1 = Optional.ofNullable(nw).orElse(createNewUser());
        System.out.println("使用orElseGet");
        User nw2 = Optional.ofNullable(nw).orElseGet(() -> createNewUser());
        System.out.println("===================");
        User nw3 = Optional.ofNullable(nw).orElseThrow(() -> new IllegalArgumentException());
        System.out.println("====================");
        User mu = new User("luqi", 28, "男");
        String username = Optional.ofNullable(mu).map(u -> u.getName()).orElse(INYES);
        System.out.println(username);
//        Optional.ofNullable(mu).flatMap();
        System.out.println("====================");
        User fu = new User("wwww", 28, "男");
        fu.setAge(12).setGender("男").setName("sss");
        boolean present = Optional.ofNullable(fu).filter(u -> u.getName() != null && u.getAge() > 20).isPresent();
        System.out.println(present);
        System.out.println("=====================");

    }

    private static User createNewUser() {
        System.out.println("创建新对象");
        return new User("wangwu", 23, "女");
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
class User {
    private String name;
    private int age;
    private String gender;

}
