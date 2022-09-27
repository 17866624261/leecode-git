import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match_0907_03 {
    @Test
    public void test(){
        System.out.println(showDown("SA SK SQ SJ S10 H10 H9"));
    }

    public String showDown(String inHand) {
        // write code here
        String[] pokers = inHand.split(" ");
        int N = pokers.length;
        if (N < 5) return "";

        Map<Character, Integer> color = new HashMap<>();
        color.put('S', 0);
        color.put('H', 1);
        color.put('C', 2);
        color.put('D', 3);

        Map<String, Integer> card = new HashMap<>();
        card.put("J", 10);
        card.put("Q", 11);
        card.put("K", 12);
        card.put("A", 0);

        int[][] hdCount = new int[4][13];
        int[] hCount = new int[4];
        int[] dCount = new int[13];

        for (String s : pokers) {
            int i = color.get(s.charAt(0));
            String dian = s.substring(1);
            Integer j = card.get(dian);
            if (j == null) {
                j = Integer.valueOf(dian) - 1;
            }
            hdCount[i][j]++;
            hCount[i]++;
            dCount[j]++;
        }

        // HuangJiaTongHuaShun
        for (int i = 0; i < 4; i++) {
            int j = 9;
            for (; j < 13; j++) {
                if (hdCount[i][j] == 0) break;
            }
            if (j == 13 && hdCount[i][0] > 0) {
                return "HuangJiaTongHuaShun";
            }
        }

        // TongHuaShun
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 13; j++) {
                if (hdCount[i][j] > 0) {
                    count++;
                } else {
                    if (count >= 5) {
                        return "TongHuaShun";
                    } else {
                        count = 0;
                    }
                }
            }
        }

        Map<Integer, Integer> cmap = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            int count = cmap.getOrDefault(dCount[i], 0);
            cmap.put(dCount[i], count + 1);
        }

        // siTiao
        if (cmap.containsKey(4)){
            return "SiTiao";
        }

        // HuLu
        if (cmap.containsKey(3) && cmap.containsKey(2)) {
            return "HuLu";
        }

        // TongHua
        for (int i = 0; i < 4; i++) {
            if (hCount[i] >= 5) {
                return "TongHua";
            }
        }

        // ShunZi
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (dCount[i] > 0) {
                count++;
            } else {
                if (count >= 5) {
                    return "ShunZi";
                } else {
                    count = 0;
                }
            }
        }

        // SanTiao
        if (cmap.containsKey(3)) {
            return "SanTiao";
        }

        // LiangDui
        if (cmap.get(2) >= 2) {
            return "LiangDui";
        }

        // YiDui
        if (cmap.get(2) == 1) {
            return "YiDui";
        }

        // GaoPai
        return "GaoPai";
    }
}
