import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer_61 {
    public boolean isStraight(int[] nums) {
        int interval = 0,num0=0;
        List<Integer> non0 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0){
                num0++;
            }else {
                non0.add(nums[i]);
            }
        }
        Collections.sort(non0);
        for (int i = 0; i < non0.size() - 1; i++) {
            if (non0.get(i+1) == non0.get(i))
                return false;
            else
                interval += non0.get(i+1) - non0.get(i) - 1;
        }
        if (interval <= num0)
            return true;
        else
            return false;
    }
}
