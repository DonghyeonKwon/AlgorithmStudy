import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        go(1, n, 1);

        System.out.print(dp[1][n]);
    }

    static int go(int l, int r, int val) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != 0) return dp[l][r];

        return dp[l][r] = Math.max(arr[l] * val + go(l+1, r, val + 1), arr[r] * val + go(l, r - 1, val + 1));
    }
}
