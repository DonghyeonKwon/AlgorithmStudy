import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        dfs(1);
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;

        for(int child : graph[node]) {
            if(visited[child]) continue;
            dfs(child);
            dp[node][0] += dp[child][1];
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
