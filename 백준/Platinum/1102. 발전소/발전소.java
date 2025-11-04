import java.io.*;
import java.util.*;

public class Main {
    static int n, k, p;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = 1 << n;
        cost = new int[n][n];
        dp = new int[n+1][k];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;  i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        String[] status = br.readLine().split("");
        p = Integer.parseInt(br.readLine());

        int pos = 0;
        int cnt = 0;
        for(int i = 0; i < status.length; i++) {
            if(status[i].equals("Y")) {
                pos = pos | (1 << i);
                cnt++;
            }
        }

        int res = dfs(cnt, pos);
        System.out.print(res == 1_000_000_000 ? -1 : res);
    }

    static int dfs(int cnt, int pNum) {
        if(cnt >= p) return 0;
        if(dp[cnt][pNum] != -1) return dp[cnt][pNum];

        dp[cnt][pNum] = 1_000_000_000;

        for(int i = 0; i < n; i++) {
            if((pNum & (1 << i)) == (1 << i)) {
                for(int j = 0; j < n; j++) {
                    if((i == j) || (pNum & (1 << j)) == (1 << j)) continue;
                    dp[cnt][pNum] = Math.min(dp[cnt][pNum], dfs(cnt+1, pNum | (1 << j)) + cost[i][j]);
                }
            }
        }

        return dp[cnt][pNum];
    }
}
