import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] pSum;
    static int[][] dp;
    static int INF = -100000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        pSum = new int[n + 1];
        dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            pSum[i+1] = pSum[i] + arr[i];
            Arrays.fill(dp[i], INF);
        }

        go(0, m);

        System.out.print(dp[0][m]);
    }

    static int go(int start, int m) {
        if(m == 0) return 0;
        if(start >= n) return INF * 100;

        if(dp[start][m] != INF) return dp[start][m];

        dp[start][m] = go(start + 1, m);
        for(int i = start; i < n; i++) {
            dp[start][m] = Math.max(dp[start][m], getRangeSum(start, i) + go(i + 2, m - 1));
        }

        return dp[start][m];
    }

    static int getRangeSum(int start, int end) {
        return pSum[end + 1] - pSum[start];
    }
}
