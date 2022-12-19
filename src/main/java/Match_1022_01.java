//public class Match_1022_01 {
//    public int planStock(int[][] order,int balance){
//        int[][] dp = new int[order.length + 1][balance + 1];
//        for (int i = 1; i <= order.length; i++) {
//            for (int j = 1; j <= balance; j++) {
//                if (j < order[i-1][1]){
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][]);
//                }
//            }
//        }
//    }
//}
