import java.util.Arrays;
import java.util.Scanner;

public class Match_0827_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] node1 = new int[m];
        int[] node2 = new int[m];
        int[] weights = new int[m];
        for (int i = 0; i < m; i++) {
            node1[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            node2[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            weights[i] = sc.nextInt();
        }
        int[][] edges = new int[n][n];
        for (int i = 0; i < m; i++) {
            int u = node1[i] - 1;
            int v = node2[i] - 1;
            int weight = weights[i];
            edges[u][v] = weight;
            edges[v][u] = weight;
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] visited = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = -1, min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0 && dist[j] < min) {
                    x = j;
                    min = dist[j];
                }
            }
            result += min;
            visited[x] = 1;
            for (int k = 0; k < n; k++) {
                if (visited[k] == 0 && edges[x][k] > 0) {
                    if (dist[k] > edges[x][k]) {
                        dist[k] = edges[x][k];
                    }
                }
            }
        }
        System.out.println(result);
    }
}
