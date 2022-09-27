public class Match_0921_02 {
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0) {
            return "";
        }
        String fir = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int k = 0;
            for (; k < fir.length() && k < strs[i].length(); k++) {
                if (fir.charAt(k) != strs[i].charAt(k)) {
                    break;
                }
            }
            fir = fir.substring(0, k);
            if (fir.equals("")) {
                return fir;
            }
        }
        return fir;
    }
}
