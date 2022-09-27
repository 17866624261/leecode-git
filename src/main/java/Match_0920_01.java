import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Match_0920_01 {
    public static void main(String[] args) {
        ArrayList<Integer> aliceValues = new ArrayList<>();
        ArrayList<Integer> bobValue = new ArrayList<>();
        aliceValues.add(1);
        aliceValues.add(3);
        aliceValues.add(4);
        bobValue.add(2);
        bobValue.add(2);
        bobValue.add(2);
        System.out.println(OpenBoxes(aliceValues,bobValue));
    }
    public static int OpenBoxes(ArrayList<Integer> aliceValues,ArrayList<Integer> bobValue){
        int alice = 0;
        int bob = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int k = 0; k <= aliceValues.size() / 2; k++) {
            int aliceIndex = 0,bobIndex = 0;
            for (int i = 1; i < aliceValues.size(); i++) {
                if (aliceValues.get(i) != -1 && aliceValues.get(i) < aliceValues.get(aliceIndex) && !map.containsKey(i)){
                    aliceIndex = i;
                }
            }
            map.put(aliceIndex,1);
            alice += aliceValues.get(aliceIndex);
            aliceValues.set(aliceIndex,-1);
            for (int i = 1; i < bobValue.size(); i++) {
                if (bobValue.get(i) != -1 && bobValue.get(i) <= aliceValues.get(bobIndex) && !map.containsKey(i)){
                    bobIndex = i;
                }
            }
            map.put(bobIndex,1);
            bob += bobValue.get(bobIndex);
            bobValue.set(bobIndex,-1);
        }
        if (alice == bob){
            return 0;
        }else if (alice > bob){
            return 1;
        }else {
            return -1;
        }
    }
}
