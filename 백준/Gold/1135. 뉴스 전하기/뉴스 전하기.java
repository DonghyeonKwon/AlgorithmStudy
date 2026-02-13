import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        dp = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) continue;
            list[p].add(i);
        }

        System.out.print(dfs(0));
    }

    static int dfs(int node) {
        for(int next: list[node]) {
            dp[next] = 1 + dfs(next);
        }

        Collections.sort(list[node],  (o, p) -> dp[p] - dp[o]);
        int res = 0;
        for(int i = 0; i < list[node].size(); i++) {
            int num = list[node].get(i);
            dp[num] += i;
            res = Math.max(res, dp[num]);
        }

        return res;
    }
}
