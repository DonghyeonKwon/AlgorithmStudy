import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        dp = new int[2][n+1];
        graph = new ArrayList[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        dfs(1);

        System.out.print(Math.max(dp[0][1], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[0][node] = 0;
        dp[1][node] = arr[node];

        for(int child : graph[node]){
            if(visited[child]) continue;
            dfs(child);
            dp[0][node] += Math.max(dp[1][child], dp[0][child]);
            dp[1][node] += dp[0][child];
        }
    }
}
