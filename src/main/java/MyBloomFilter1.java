import java.util.BitSet;

public class MyBloomFilter1 {
    // 位数组的大小
    private static final int DEFAULT_SIZE = 2 << 24;
    // 通过这个数组可以创建6个不同的hash函数
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};
    // 创建一个位数组，元素只能是0或者1
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    // 创建包含hash函数的类的数组
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter1() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    // 添加元素，hash之后对应位置置为true
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    // 判断某个元素是否位于位数组之中
    public boolean contains(Object value) {
        boolean res = true;
        for (SimpleHash f : func) {
            res = res && bits.get(f.hash(value));
        }
        return res;
    }


    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        // 计算hash值
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }
}
