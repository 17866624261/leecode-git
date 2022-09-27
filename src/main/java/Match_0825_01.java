public class Match_0825_01 {
//    public static void main(String[] args) {
//        int[][] nodes = new int[][]{{1,2,3},{3},{3},{4},{}};
//        System.out.println(DagPathNum(nodes));
//
//    }
    private int res = 0;
    public int DagPathNum (int[][] nodes) {
        // write code here
        if (nodes == null || nodes[0] == null){
            return 0;
        }
        backtracking(nodes,0);
        return res;
    }
    public void backtracking(int[][] nodes,int curNode){
        if (curNode == 4){
            res ++;
        }
        for (int i = 0; i < nodes[curNode].length; i++) {
                backtracking(nodes,nodes[curNode][i]);
        }
        return;
    }
}
