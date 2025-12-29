import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dp = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 2; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            list[i].add(p);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[j] += w;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n; i >= 2; i--) {
            go(i);
        }

        for(int i = 1; i <= n; i++) {
            sb.append(dp[i] + " ");
        }

        System.out.print(sb);
    }

    static int go(int idx) {
        if(idx == 1) return 0;
        if(visited[idx]) return dp[idx];

        visited[idx] = true;
        for(int next : list[idx]) {
            dp[idx] += go(next);
        }

        return dp[idx];
    }
}
