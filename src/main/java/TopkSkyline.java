//import java.util.List;
//
//public class TopkSkyline {
//    List<Integer> topkSky(int[] u, int[][] Q, int threshold) {
//        // 根据公式4得到每个目标用户每个属性的权重
//        int[] Wt = getWt(u,b);
//        // 将每个权重分别乘Q中的每个属性,得到新Q
//        for (int i = 0; i < Wt.length; i++) {
//            for (int j = 0; j < Q[0].length; j++) {
//                Q[i][j] *= Wt[i];
//            }
//        }
//        // 步骤2 得到聚合程度对用户评分相似度的影响权重
//        int[] O = getO(u);
//        // 将这个权重乘入Q
//        for (int i = 0; i < O.length; i++) {
//            for (int j = 0; j < Q[0].length; j++) {
//                Q[i][j] *= O[i];
//            }
//        }
//        // 步骤4，得到相似度矩阵R
//        double[][] R = getNewR(u,Q);
//        int threshold2 = 1;
//        // 根据threshold2对R进行排序，然后排除掉一部分用户
//
//        // 根据SkyLine计算得到一部分候选用户集合G
//        ArrayList<> G = skyLine(R);
//        // 通过y值对候选集合G排序，得到top-k个数据
//        ArrayList<> Du = getY(G);
//
//        return null;
//    }
//
//    int[] getWt(int[] u, int b) {
//        // 公式4
//        int[] Wt = new int[u.length];
//        for (int i = 0; i < u.length; i++) {
//            int Wi = Math.exp(-(1 / b) * (ITumax - ITui) + (1 / (1 - b)) * (Yumax - Tui));
//            Wt[i] = Wi;
//        }
//        return Wt;
//    }
//    int[] getO(int[] u){
//        int[] O = new int[u.length];
//        for (int i = 0; i < u.length; i++) {
//            O[i] = Math.exp(Math.abs(N(u)/N(i)));
//        }
//        return O;
//    }
//    double[][] getNewR(int[] u ,int[][] Q){
//        int[] O = getO(u);
//        double[][] R = new double[Q.length][Q[0].length];
//        double[] PCC = new double[u.length];
//        for (int i = 0; i < u.length; i++) {
//            for (int j = 0; j < Q[0].length; j++) {
//                PCC[j] = Math.sqrt(Math.pow(u[j],2)+Math.pow(Q[i][j],2));
//                R[i][j] = PCC[j] * O[j];
//            }
//        }
//        return R;
//    }
//}
