import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

public class TestMyBloomFilter {
    @Test
    public void test01() {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github/com/17866624261";
        MyBloomFilter1 filter = new MyBloomFilter1();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }

    @Test
    public void testGuavaBloomFilter() {
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01
        );
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
