import org.junit.Test;

public class Match_6201 {
    @Test
    public void test(){
        int[] pref = new int[]{413935,351122};
//        int[] pref = new int[]{5,2,0,3,1};
        for (int n : findArray(pref)) {
            System.out.print(n+"\t");
        }
    }
    public int[] findArray(int[] pref) {
        if (pref.length == 1) return pref;
        int[] res = new int[pref.length];
        res[0] = pref[0];
        int preValue = res[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = preValue ^ pref[i];
            preValue = preValue ^ res[i];
        }
        return res;
    }
}
