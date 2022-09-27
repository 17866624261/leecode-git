import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.nio.charset.StandardCharsets;

public class ZookeeperTestService {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME,MAX_RETRIES);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder().connectString("101.43.176.82:2181").retryPolicy(retryPolicy).build();
        zkClient.start();
//        zkClient.create().forPath("/node1/00001");
//        zkClient.create().withMode(CreateMode.PERSISTENT).forPath("/node1/00002");
        zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node1/00001","java".getBytes(StandardCharsets.UTF_8));
        zkClient.checkExists().forPath("/node1/00001");
//        zkClient.delete().deletingChildrenIfNeeded().forPath("/node1");
    }
}
