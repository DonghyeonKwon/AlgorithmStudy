import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= l; j++) {
                for(int k = 1; k <= r; k++) {
                    dp[i][j][k] = dp[i-1][j-1][k] +
                            dp[i-1][j][k-1] +
                            dp[i-1][j][k] * (i-2);
                    dp[i][j][k] %= mod;
                }
            }
        }

        System.out.print(dp[n][l][r]);
    }
}
