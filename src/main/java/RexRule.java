import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RexRule {
    public static void main(String[] args) {
        BigDecimal hours = new BigDecimal(10);
        BigDecimal claimAmount;
        String rex_rule = "16-:0,16+72:5,72+96:10,96+:15";
        String pattern = ".*runoob.*";
        List<String> rules = Arrays.asList(rex_rule.split(","));
        for (String rule : rules) {
            String[] ruleItem = rule.split(":");
            // 小于
            if (null != ruleItem && ruleItem.length == 2 && ruleItem[0].indexOf("-") > 0) {
                if (hours.compareTo(new BigDecimal(Integer.parseInt(ruleItem[0].substring(0, ruleItem[0].indexOf("-"))))) <= 0) {
                    claimAmount = new BigDecimal(ruleItem[1]);
                }
            }
            if (null != ruleItem && ruleItem.length == 2 && ruleItem[0].indexOf("+") > 0) {
                if (ruleItem[0].split("\\+").length == 2) {
                    // 区间值
                    if (hours.compareTo(new BigDecimal(Integer.parseInt(ruleItem[0].split("\\+")[0]))) > 0
                            && hours.compareTo(new BigDecimal(Integer.parseInt(ruleItem[0].split("\\+")[1]))) <= 0) {
                        claimAmount = new BigDecimal(ruleItem[1]);
                    }
                }else if (ruleItem[0].split("\\+").length == 1){
                    // 大于
                    if (hours.compareTo(new BigDecimal(Integer.parseInt(ruleItem[0].split("\\+")[0])))<=0){
                        claimAmount = new BigDecimal(ruleItem[1]);
                    }
                }
            }
        }
        System.out.println();
    }
}
