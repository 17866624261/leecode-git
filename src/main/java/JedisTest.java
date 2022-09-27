import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import redis.clients.jedis.Jedis;

import java.io.Serializable;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("101.43.176.82",6399);
        jedis.auth("yun00970212");
        jedis.set("peopleRedisTest:people",new PeopleToRedisTest("zhangsan",18).toString());
        jedis.expire("peopleRedisTest:people",1000);

    }

}
class PeopleToRedisTest implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PeopleToRedisTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PeopleToRedisTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
