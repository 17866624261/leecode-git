import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Match_6200 {
    @Test
    public void test(){
        int[][] logs = new int[][]{{0,3},{2,5},{0,9},{1,15}};
        int n = 10;
        System.out.println(hardestWorker(n,logs));
    }
    public int hardestWorker(int n, int[][] logs) {
        List<Integer> maxId = new ArrayList<>();
        int maxTime = 0;
        int preTime = 0;
        for (int i = 0; i < logs.length; i++) {
            int time = logs[i][1] - preTime;
            preTime += time;
            if (time > maxTime) {
                maxTime = time;
                maxId.clear();
                maxId.add(logs[i][0]);
            }
            if (time == maxTime){
                maxId.add(logs[i][0]);
            }
        }
        Collections.sort(maxId);
        return maxId.get(0);
    }
}
