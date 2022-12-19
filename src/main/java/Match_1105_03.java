//import java.util.PriorityQueue;
//
//public class Match_1105_03 {
//    public static void main(String[] args) {
//        int[][] userRequests = {{0,0,1},{0,1,3},{0,2,2}};
//        for (int i:customerDistribution(3,userRequests)) {
//            System.out.println(i);
//        }
//    }
//    public int[] customerDistribution (int brokerCount, int[][] userRequests) {
//        // write code here
//        int[] res = new int[brokerCount];
//        int[] service = new int[brokerCount];
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
//        for (int i = 0; i < userRequests.length; i++) {
//            priorityQueue.add(userRequests[i]);
//        }
//        while (!priorityQueue.isEmpty()){
//            int[] cur = priorityQueue.poll();
//            int hopeId = cur[0];
//            int arriveTime = cur[1];
//            int needTime = cur[2];
//            if (service[hopeId] <= arriveTime){
//                service[hopeId] = arriveTime + needTime;
//                res[hopeId] += needTime;
//            }else {
//                for (int j = 0; j < brokerCount; j++) {
//                    if (service[j] <= arriveTime){
//                        service[j] = arriveTime + needTime;
//                        res[j] += needTime;
//                        break;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}
