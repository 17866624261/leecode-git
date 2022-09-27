import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissionTest {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://101.43.176.82:6399").setPassword("yun00970212");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("testLock");
        lock.lock();
    }
}
