import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableFutureMallDemo {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("tianmao"),
            new NetMall("taobao")
    );

    public static List<String> getPrice(List<NetMall> list, String productName) {

        return list.stream().map(netMall -> String.format(productName + " in %s price is %s", netMall.getNetMallName(), netMall.calPrice(productName))).collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list,String productName){
        return list.stream().map(netMall ->
                CompletableFuture.supplyAsync(()->String.format(productName + " in %s price is %s",
                        netMall.getNetMallName(),
                        netMall.calPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(s->s.join())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        List<String> list1 = getPrice(list, "MySQL");
        List<String> list1 = getPriceByCompletableFuture(list,"MySQL");
        for (String s : list1) {
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (endTime - startTime) + "ms");
    }
}

class NetMall {
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public BigDecimal calPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
        BigDecimal res = new BigDecimal(String.valueOf(value)).setScale(2, RoundingMode.HALF_UP);
        return res;
    }
}
