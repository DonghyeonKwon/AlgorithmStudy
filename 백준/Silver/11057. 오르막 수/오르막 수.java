import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];
        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 9; j >= 0; j--) {
                for(int k = j; k >= 0; k--) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }

        System.out.print(sum);
    }
}
